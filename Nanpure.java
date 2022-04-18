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

    static void solve(int x){
        if(x > MAX_BOARD - 1){
            print_board();
        }else{
            if(board[x] != 0){ //空白ではないか
                solve(x + 1);
            }else{
                for(int n = 1;n <= 9;n++){
                    if(borad[x] != n){
                        borad[x] = n;
                        solve(x + 1);
                        board[x] = 0;
                    }
                }
            }
        }
    }
    static void print_board(){
        for(int i = 0;i < borad.length;i++){
            if(mod(i + 1,9) != 0){
                System.out.print(borad[i] + ",");
            }else{
                System.out.println(borad[i]);
            }
        }
    }
    static boolean row_ok(int n,int x){
        return true;
    }
    static boolean column_ok(int n,int x){
        return true;
    }
    static boolean frame_ok(int n,int x){
        return true;
    }
    static boolean check_ok(int n,int x){
        return true;
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