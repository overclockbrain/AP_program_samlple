class Nanpure{
    public static final int MAX_BOARD = 81;
    public static int[] board = {
                        2,0,1,0,9,0,7,0,0,
                        0,4,0,2,0,0,3,0,0,
                        5,0,0,0,0,8,0,2,9,
                        0,9,0,6,7,0,2,0,0,
                        6,0,0,3,0,5,0,0,4,
                        0,0,7,0,4,9,0,1,0,
                        7,6,0,9,0,0,0,0,3,
                        0,0,9,0,0,6,0,4,0,
                        0,0,4,0,1,0,6,0,0
    };
    static int i = 0;
    static void solve(int x){
        if(x > MAX_BOARD - 1){
            //問題通りにするとうまく動かない。
            print_board();
            i += 1; 
            System.out.println("繰り返し" + i);
            //System.exit(0);
        }else{
            if(board[x] != 0){ //空白ではないか
                solve(x + 1);
            }else{
                for(int n = 1;n <= 9;n++){
                    if(check_ok(n,x)){
                        board[x] = n;
                        solve(x + 1);
                        board[x] = 0;
                    }
                }
            }
        }
    }

    static void print_board(){
        for(int i = 0;i < board.length;i++){
            if(mod(i + 1,9) != 0){
                System.out.print(board[i] + ",");
            }else{
                System.out.println(board[i]);
            }
        }
    }

    static boolean row_ok(int n,int x){
        int row_top = div(x,9) * 9;
        for(int i = 0;i <= 8;i++){
            if(board[row_top + i] == n){
                return false;
            }
        }
        return true;
    }

    static boolean column_ok(int n,int x){
        int column_top = mod(x,9);
        for(int i = 0;i <= 8;i++){
            if(board[column_top + 9 * i] == n){
                return false;
            }
        }
        return true;
    }

    static boolean frame_ok(int n,int x){
        int frame_top = x - mod(div(x,9),3) - mod(x,3);
        for(int i = 0;i <= 2;i++){
            for(int j = 0;j <= 2;j++){
                if(board[frame_top + 9 * i + j] == n){
                    return false;
                }
            }
        }
        return true;
    }
    static boolean check_ok(int n,int x){
        if(row_ok(n,x) && column_ok(n,x) ){
            return true;
        }
        return false;
    }
    static int div(int n,int m){
        return n / m;
    }
    static int mod(int n,int m){
        return n % m;
    }
    public static void main(String[] args) {
        solve(0);
    }
}