import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;

import java.net.URL;
//发的回复的好的辅导费545
//发的回复的好的啊实打实大

    public class jieKo {
        public static void main(String[] args) {
            try {
                RestUtil restUtil = new RestUtil();
                String load = restUtil.load("", "");
                System.out.println(load);
            } catch (Exception e) {

                e.printStackTrace();
            }
        }
        public static class RestUtil{
            public String load(String url,String query) throws Exception{
                URL urlRest = new URL(url);
                HttpURLConnection conn = (HttpURLConnection)urlRest.openConnection();
                conn.setRequestMethod("Post");
                conn.setDoOutput(true);
                conn.setAllowUserInteraction(false);
                PrintStream printStream = new PrintStream(conn.getOutputStream());
                printStream.print(query);
                printStream.close();

                BufferedReader bReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                String line,resultStr="";

                while(null != (line=bReader.readLine()))
                {
                    resultStr +=line;
                }
                System.out.println("3412412---"+resultStr);
                bReader.close();

                return resultStr;

            }


        }


    }


