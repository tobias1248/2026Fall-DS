import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Please input the test file name.");
		String filename = s.next();
		File file = new File(filename);

		s.close();
		Scanner sc = new Scanner(file);
		KeywordList kLst = new KeywordList();
		
		while(sc.hasNext()){
		    String cmd = sc.next();
		    switch(cmd){
	        	case "add":
	        	{
	        		String name = sc.next();
	        		int count = sc.nextInt();
	        		float weight = sc.nextFloat();
	        		Keyword k = new Keyword(name, count, weight);
	        		kLst.add(k);
	        	}
	        		break;
	        	
	        	case "outputIndex":
	        	{
	        		int index = sc.nextInt();
            		kLst.outputIndex(index);
	        	}
	        		break;	
	        		
	        	case "outputCount":
	        	{
	        		int count = sc.nextInt();
            		kLst.outputCount(count);
	        	}
	        		break;
	        		
	        	case "outputHas":
        	    {
	        		String pattern = sc.next();
	        		kLst.outputHas(pattern);
        	    }
        	    	break;
        	    
	        	case "outputName":
        	    {
	        		String name = sc.next();
	        		kLst.outputName(name);
        	    }
        	    	break;
        	    	
        	    case "outputFirstN":
        	    {
        	    	int n = sc.nextInt();
        	    	kLst.outputFirstN(n);
        	    }
        	    	break;
        	    	
        	    case "outputScore":        	          
        	    	kLst.outputScore();        		        	    
        	    	break;
        	    	
        	    case "deleteIndex":
        	    {
        	    	int index = sc.nextInt();
        	    	kLst.deleteIndex(index);   
        	    	
        	    }
        	    	break;
        	    	
        	    case "deleteCount":
        	    {
        	    	int count = sc.nextInt();
        	    	kLst.deleteCount(count);       		
        	    }
        	    	break;
        	    	
        	    case "deleteHas":
	    	    {
		    		String pattern = sc.next();
		    		kLst.deleteHas(pattern);	    		
	    	    }
	    	    	break;	
	    	    	
        	    case "deleteName":
	    	    {
		    		String name = sc.next();
		    		kLst.deleteName(name);	    		
	    	    }
	    	    	break;		
        	    	
        	    case "deleteFirstN":
        	    {
        	    	int n = sc.nextInt();
        	    	kLst.deleteFirstN(n);       		
        	    }
        	    	break;
        	    	
        	    case "deleteAll":
        	    	kLst.deleteAll();       		
        	    	break;
        	    
        	    
        	    default:
        	    	System.out.println("InvalidOperation");       	    	      
		    }
		}
		sc.close();
	}

}