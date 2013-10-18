package com.cdac.svarn.business.employeemgmt;

public class PassPhrase {

  public static final int MIN_LENGTH = 10;


  protected static java.util.Random r = new java.util.Random();


 protected static char[] goodChar = {'a','b','c','d','e','f','g','h','j','k','m','n','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','J','K','M','N','P','Q','R','S','T','U','V','W','X','Y','Z','0','1','2','3','4','5','6','7','8','9'};

  public  String getNext() {
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < MIN_LENGTH; i++) {
      sb.append(goodChar[r.nextInt(goodChar.length)]);
    }
    return sb.toString();
  }

  /*public static void main(String[] argv) {
PassPhrase obj = new PassPhrase();
    for (int i = 0; i < 20; i++) {
      
	String username = obj.UserName();
	String password = obj.getNext();
System.out.println("INSERT INTO KIT(LOGIN_ID, LOGIN_PASSWORD) VALUES('"+username+"','"+password+"');");
	
    }
}*/
 public  String UserName () {

                java.util.Random rand = new java.util.Random();

                int num1, num2, num3;
                String randNo;
              

                        num1 = rand.nextInt (900) + 100;
                        num2 = rand.nextInt (643) + 100;
                        num3 = rand.nextInt (9000) + 1000;
                        randNo=num1+"-"+num2+"-"+num3;
                        return randNo;
   
        }

}
