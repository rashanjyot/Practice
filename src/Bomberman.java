import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bomberman {




    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }


        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    static byte arr[][];
    public static void main(String args[])throws Exception
    {


        FastReader s=new FastReader();
        arr=new byte[s.nextInt()][s.nextInt()];
        int seconds=s.nextInt();
        for(short i=0;i<arr.length;i++)
        {
            for(short j=0;j<arr[i].length;j++)
            {

                if(s.br.read()==46)
                    arr[i][j]=-1;
                else
                    arr[i][j]=0;
            }
            s.br.readLine();



        }






//        java.io.BufferedReader br=new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
//        String s[]=br.readLine().split("\\s+");
//       arr =new byte[Short.parseShort(s[0])][Short.parseShort(s[1])];
//        int seconds=Integer.parseInt(s[2]);
//        for(short i=0;i<arr.length;i++)
//        {
//            for(short j=0;j<arr[i].length;j++)
//            {
//                if(br.read()==46)
//                    arr[i][j]=-1;
//                else
//                    arr[i][j]=0;
//            }
//            br.readLine();
//
//        }

        for(int i=0;i<seconds;i++)
        {
            if(i%2==0)
            {
                secondElapsed(false);

            blast();
            }

            else

            {
                secondElapsed(true);
            }


        }

        System.out.println();

        for (int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[i].length;j++)
            {
                if(arr[i][j]==-1)
                    System.out.print('.');
                else
                    System.out.print('O');
            }
            System.out.println();
        }




    }

    public static void secondElapsed(boolean planted)
    {
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[i].length;j++)
            {
                if(arr[i][j]>=0)
                {
                    arr[i][j]++;
                }
                else if(planted)
                {
                    arr[i][j]=0;
                }




            }
        }


    }


    public static void blast()
    {

        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[i].length;j++)
            {
                if(arr[i][j]==3)
                {
                    try{ if(arr[i+1][j]!=3) arr[i+1][j]=-1; }catch (Exception e){}
                    try{ if(arr[i-1][j]!=3) arr[i-1][j]=-1; }catch (Exception e){}
                    try{ if(arr[i][j+1]!=3) arr[i][j+1]=-1; }catch (Exception e){}
                    try{ if(arr[i][j-1]!=3) arr[i][j-1]=-1; }catch (Exception e){}
                    arr[i][j]=-1;
                }




            }
        }

    }






}

