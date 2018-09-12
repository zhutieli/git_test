public static void main(String[] args) {
        try {
        RestUtil restUtil = new RestUtil();
        String load = restUtil.load("", "");
        System.out.println(load);
        } catch (Exception e) {
//asdasdasds
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