package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class _71_SimplifyPath {

    public static void main(String[] args) {
        _71_SimplifyPath obj = new _71_SimplifyPath();

        String path = "/home//foo/";
        System.out.println(obj.simplifyPath(path));
    }

    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        String[] tokens =path.split("/");

        for(int i=0;i<tokens.length;i++){
            if(!stack.isEmpty()  && tokens[i].equals("..")) {
                stack.pop();
            }
            else if(!tokens[i].equals("") && !tokens[i].equals(".") && !tokens[i].equals("..")) {
                stack.push(tokens[i]);
            }
        }


        if(stack.isEmpty()) return "/";
        while(!stack.isEmpty()){
            res.insert(0,stack.pop()).insert(0,"/");
        }

        return res.toString();
    }
}
