package atcoder;

public class QASaturday {
    private int solve(String day){
        if(day.equals("Saturday"))return 1;
        if(day.equals("Sunday"))return 7;
        if(day.equals("Monday"))return 6;
        if(day.equals("Tuesday"))return 5;
        if(day.equals("Wednesday"))return 4;
        if(day.equals("Thursday"))return 3;
        if(day.equals("Friday"))return 2;
        return -1;
    }

    public static void main(String[] args) {
        QASaturday q = new QASaturday();
        String day = new java.util.Scanner(System.in).next();
        System.out.println(q.solve(day));
    }
}
