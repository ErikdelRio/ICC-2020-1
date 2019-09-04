public class HeyJude {
    public static void main(String[] args){
	final String JUDE = "Hey Jude ";

	final String DONT = "don't ";
	final String MAKE_BAD = "make it bad";
	final String AFRAID = "be afraid";
	final String LET_DOWN = "let me down";
	
	final String SAD_SONG = "take a sad song and make it better";
	final String MADE_TO = "you were made to go out";
	final String FOUND_HER = "you have found her, now go";
	final String GET_HER = " and get her";

	final String REMEMBER = "remember to let her ";
	final String INTO_HEART = "into your heart";
	final String UNDER_SKIN = "under your skin";

	final String THEN = "then you ";
	final String CAN_START = "can start ";
	final String BEGIN = "begin ";
	final String MAKE_BETTER= "to make it better";
	final String BETTER = "better ";
	final String NA = "na ";
	final String OH = "oh";

	byte i = 0;
	while (i<4){
	    // Línea 1
	    System.out.print(JUDE+DONT);
	    if(i%3==0){
		System.out.print(MAKE_BAD);
	    } else {
		if (i==1){
		    System.out.print(AFRAID);
		} else {
		    System.out.print(LET_DOWN);
		}
	    }
	    System.out.println();
	    
	    // Línea 2
	    if(i%3==0){
		System.out.print(SAD_SONG);
	    } else {
		if(i==1){
		    System.out.print(MADE_TO);
		} else {
		    System.out.print(FOUND_HER);
		}
		System.out.print(GET_HER);
	    }
	    System.out.println();

	    // Línea 3
	    System.out.print(REMEMBER);
	    if(i%2==0){
		System.out.print(INTO_HEART);
	    } else {
		System.out.print(UNDER_SKIN);
	    }
	    System.out.println();

	    // Línea 4
	    System.out.print(THEN);
	    if(i%2==0){
		System.out.print(CAN_START);
	    } else {
		System.out.print(BEGIN);
	    }
	    System.out.print(MAKE_BETTER);
	    System.out.println();

	    // Línea 5
	    if(i==3){
		byte j = 0;
		while(j<5){
		    System.out.print(BETTER);
		    j+=1;
		}
		System.out.print(OH);
		System.out.println();
	    }
	    
	    System.out.println();

	    // Nanana
	    if(i!=0){
		byte j = 0;
		while (j<10){
		    System.out.print(NA);
		    j+=1;
		}
		if (i!=3){
		    System.out.println("\n");
		}
	    }
	    i+=1;
	}
	System.out.println(JUDE);
    }
}
