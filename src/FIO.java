import java.util.Scanner;
import java.util.Date;
public class FIO {
    static boolean isValidDate(int day1, int month1, int year1) throws NotValidDateException {
        if (day1 > dayInMonth(month1, year1))
        {
            throw new NotValidDateException("Not valid date");
        }
        return true;
    }
    static boolean isLeapYear(int year)
    {
        if (((year % 4 == 0) && (year % 100 != 0)) || year % 400==0)
        { return true;}
        else return false;
    }
    static int dayInMonth(int month, int year)
    {
        if (month == 0 && year == 0) return 0;
        int days[]={ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (isLeapYear(year)==true) days[1] = 29;
        return days[month - 1];
    }
    public static void main(String[] args) {
        try{
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите ФИО:");
        String fullname = sc.nextLine();
        String[] str=fullname.split(" ");

            if (str.length!=3){
                throw new NotValidDateException("Valid Name");
            }
            System.out.println(str[0]+" "+str[1].charAt(0)+". "+str[2].charAt(0)+".");
           if(str[2].endsWith("ич")){
               System.out.println("Пол: мужской ");
           } else
            if(str[2].endsWith("на")){
                System.out.println("Пол: женский ");
            }
        else {System.out.println("Пол: невозможно определить ");}

        System.out.println("Введите дату рождения:");
        String date = sc.nextLine();
        int day,month,year;
        String sMas[] = date.split("[.]");
        day=Integer.parseInt(sMas[0]);
        month=Integer.parseInt(sMas[1]);
        year=Integer.parseInt(sMas[2]);
        boolean check; check=isValidDate(day,month,year);
        if (check==false){System.out.println("Ошибка: Неверный формат даты."); return;}
        int age=0;
        Date curDate = new Date();
        String curYear = String.format("%tY", curDate);
        String curMonth = String.format("%tm", curDate);
        String curDay = String.format("%td", curDate);
        int checkDay=Integer.parseInt(curDay);
        int checkMonth=Integer.parseInt(curMonth);
        int checkYear=Integer.parseInt(curYear);

        if (month<checkMonth){age=checkYear-year;}
        if (month>checkMonth){age=checkYear-1-year;}
        if (month==checkMonth){
            if (day<checkDay) {age=checkYear-year;}
            if (day>=checkDay) {age=checkYear-1-year;}
        }
        System.out.println("Возраст: "+age);}
        catch (NotValidDateException e){
            System.out.println(e);
        }
        catch (NumberFormatException k){
            System.out.println("Not valid date");
        }
    }
}
