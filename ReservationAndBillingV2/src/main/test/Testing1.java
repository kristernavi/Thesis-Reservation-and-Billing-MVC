import java.util.Calendar;

public class Testing1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar prevYear = Calendar.getInstance();
		int yr = prevYear.get(Calendar.YEAR);
	    
	    int counter = 0;
	    while(yr!=2003){
	    	prevYear.add(Calendar.YEAR, counter);
	    	yr = prevYear.get(Calendar.YEAR);
	    	counter=counter - 1;
	    	prevYear = Calendar.getInstance();
	    	System.out.println(yr);
	    	System.out.println(counter);
	    }
	}

}
