import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

class test {
	public static void main(String[] args) {
		String str = "";
		try {
			str = readFile("dictionary-algs4.txt");
		}
		catch( Exception e) {
			System.out.println("Fucked");
		}		
		finally {
			String[] strArr = str.split("\n");
			String t = "{";
			for(String i : strArr) {
				t +=( "\"" + i + "\"" + ",");
			}
			System.out.println(t);
			// System.out.println(Arrays.toString(strArr));
		}
	}
	static String readFile(String fileName) throws IOException {
		    BufferedReader br = new BufferedReader(new FileReader(fileName));
		    try {
		        StringBuilder sb = new StringBuilder();
		        String line = br.readLine();

		        while (line != null) {
		            sb.append(line);
		            sb.append("\n");
		            line = br.readLine();
		        }
		        return sb.toString();
		    } finally {
		        br.close();
		    }
		}
}