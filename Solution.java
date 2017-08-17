import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	private static HashMap<Long, Long> coll = new HashMap<>();	// collection of fibonacci terms
		
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		coll.put(0L, 0L);
		coll.put(1L, 1L);
		
		String line;

		while((line = br.readLine()) != null){
			long n = Long.parseLong(line);
			if(coll.containsKey(n))
				System.out.println(coll.get(n));
			else{
				long r = fibo(n);
				coll.put(n, r);
				System.out.println(r);	
			}
		}
		
    }

	private static long fibo(long n){		
		if(coll.containsKey(n))
				return coll.get(n);
		else{
			long f1 = fibo(n-1);
			coll.put(n - 1, f1);
			long f2 = fibo(n-2);
			coll.put(n - 2, f2);
			return f1 + f2;
		}
	}

}
