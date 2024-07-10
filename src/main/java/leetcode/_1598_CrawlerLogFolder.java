package leetcode;

public class _1598_CrawlerLogFolder {

    public static void main(String[] args) {
        _1598_CrawlerLogFolder obj = new _1598_CrawlerLogFolder();

        String[] logs = {"./","../","./"};
        System.out.println(obj.minOperations(logs));
    }

    public int minOperations(String[] logs) {
        int currLevel = 0; //user starts from the main folder

        for(String log : logs) {
            if (log.equals("../")) {
                if (currLevel > 0) {
                    currLevel--;
                }
            } else if(!log.equals("./")){
                currLevel++;
            }
        }
        return currLevel;
    }
}
