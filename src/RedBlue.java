

public class RedBlue {



    static long unitLapTime[];

    public static void main(String args[])throws java.lang.Exception
    {

        java.io.BufferedReader br=new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        String s[]=br.readLine().trim().split("\\s+");
        int tankCapacity=Integer.parseInt(s[0]);
        int races=Integer.parseInt(s[1]);
        s=br.readLine().split("\\s+");
         unitLapTime =new long[tankCapacity];
        for(int i=0;i<s.length;i++)
        {
            unitLapTime[i]=Long.parseLong(s[i]);
        }

        for(int i=0;i<races;i++)
        {
            s=br.readLine().trim().split("\\s+");
            calculateMinTime(Long.parseLong(s[0]),Long.parseLong(s[1]));
        }


    }

    public static void calculateMinTime(long laps, long pitTime)
    {
        long time=0;
        long numLapTime[]=new long[unitLapTime.length];
        for(int i=0;i< unitLapTime.length;i++)
        {
            if(i>0)
            {
                if(pitTime+unitLapTime[0]<unitLapTime[i])
                    numLapTime[i]=numLapTime[i-1]+pitTime+unitLapTime[0];
                else
                    numLapTime[i]=numLapTime[i-1]+unitLapTime[i];
            }
            else
            {
               numLapTime[i]=unitLapTime[i];
            }
        }

        while (laps>0)
        {

            if( laps>unitLapTime.length)
            {
                laps-=unitLapTime.length;
                time+=numLapTime[numLapTime.length-1]+pitTime;
            }
            else
            {
                time+=numLapTime[(int)laps-1];
                break;
            }
        }
        System.out.println(time);
    }
}
