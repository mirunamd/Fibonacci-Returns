import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	private static HashMap<Integer, BigInteger> coll = new HashMap<>();	// collection of fibonacci terms
		
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		coll.put(0, BigInteger.ZERO);
		coll.put(1, BigInteger.ONE);
		
		String line;

		while((line = br.readLine()) != null){
			int n = Integer.parseInt(line);
			if(coll.containsKey(n))
				System.out.println(coll.get(n));
			else {
				BigInteger r = fibo(n);
				coll.put(n, r);
				System.out.println(r);	
			}
		}
		
    }

	private static BigInteger fibo(int n){		
		if(coll.containsKey(n))
				return coll.get(n);
		else{
			BigInteger f1 = fibo(n - 1);
			if(!coll.containsKey(n - 1))
				coll.put(n - 1, f1);
			if(!coll.containsKey(n - 2))
				coll.put(n - 1, f1);
			BigInteger f2 = fibo(n-2);
			coll.put(n - 2, f2);
			return f1.add(f2);
		}
	}

}
