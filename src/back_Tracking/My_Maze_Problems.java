package back_Tracking;

import java.util.ArrayList;
import java.util.List;

public class My_Maze_Problems {

    public static void main(String[] args) {
        System.out.println(path("",0,0));
        System.out.println(count(3,3));
        System.out.println(pathcount(3,3));
        pathP("",3,3);
        System.out.println(pathRet("",3,3));
        pathDiagonal("",3,3);
        System.out.println(pathDiagonalRet("",3,3));
        System.out.println(pathDiagonalCount("",3,3));
    }


    static List<String> path(String p,int down,int right){

        List<String> list = new ArrayList<String>();
        if(right == 2 && down == 2){
            list.add(p);
            return list;
        }

        if(right == 2){
            list.addAll(path(p + 'D',down + 1,right));
        }
        else if (down == 2) {
            list.addAll(path(p + 'R',down,right + 1));
        }
        else{
            list.addAll(path(p + 'D',down + 1,right));
            list.addAll(path(p + 'R',down,right + 1));
        }
        return list;
    }

    static  int count(int r, int c){
        if(r == 1 || c == 1){
            return 1;
        }
        int left = count(r-1,c);
        int right = count(r,c-1);
        return left + right;
    }

    static int pathcount(int r, int c){
        int count = 0;
        if(r == 1 && c == 1){
            return 1;
        }
        if (r==1){
            count += pathcount(r,c-1);
        } else if (c==1) {
            count += pathcount(r-1,c);
        }
        else{
            count += pathcount(r,c-1);
            count += pathcount(r-1,c);
        }
        return count;
    }

    static  void pathP(String p,int r,int c){
        if (r==1 && c==1){
            System.out.println(p);
            return;
        }
        if(r>1){
            pathP(p + 'D',r-1,c);
        }
        if(c>1){
            pathP(p + 'R',r,c-1);
        }
    }

    static  List<String> pathRet(String p,int r,int c){
        if (r==1 && c==1){
            List<String> list = new ArrayList<String>();
            list.add(p);
            return list;
        }
        List<String> list = new ArrayList<String>();
        if(r>1){
            list.addAll(pathRet(p + 'D',r-1,c));
        }
        if(c>1){
            list.addAll(pathRet(p + 'R',r,c-1));
        }
        return list;
    }

    static  void pathDiagonal(String p,int r,int c){
        if (r==1 && c==1){
            System.out.println(p);
            return;
        }
        if(r>1){
            pathDiagonal(p + 'V',r-1,c);
        }
        if(c>1){
            pathDiagonal(p + 'H',r,c-1);
        }
        if(r>1 && c>1){
            pathDiagonal(p + 'D',r-1,c-1);
        }
    }

    static  List<String> pathDiagonalRet(String p,int r,int c){
        if (r==1 && c==1){
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        List<String> list = new ArrayList<>();
        if(r>1){
            list.addAll(pathDiagonalRet(p + 'V',r-1,c));
        }
        if(c>1){
            list.addAll(pathDiagonalRet(p + 'H',r,c-1));
        }
        if(r>1 && c>1){
            list.addAll(pathDiagonalRet(p + 'D',r-1,c-1));
        }
        return list;
    }

    static  int pathDiagonalCount(String p,int r,int c){
        int count = 0;
        if (r==1 && c==1){
            return 1;
        }
        if(r>1){
            count += pathDiagonalCount(p + 'V',r-1,c);
        }
        if(c>1){
            count += pathDiagonalCount(p + 'H',r,c-1);
        }
        if(r>1 && c>1){
            count += pathDiagonalCount(p + 'D',r-1,c-1);
        }
        return count;
    }

}

