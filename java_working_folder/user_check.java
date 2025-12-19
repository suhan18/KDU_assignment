import java.util.Scanner;
class user_check
{
    public static void main(String[] args) {
        Scanner obj=new Scanner(System.in);
        System.out.println("Enter first string");
        String str1=obj.nextLine();
        System.out.println("Enter second string");
        String str2=obj.nextLine();
        int len1=str1.length();
        int len2=str2.length();
        System.out.println("Length 1: "+len1);
        System.out.println("Length 2: "+len2);
        if(len1==len2)
        System.out.println("Lengths match: true");
        if(str1.equals(str2))
        System.out.println("Strings match: true");
    }
}