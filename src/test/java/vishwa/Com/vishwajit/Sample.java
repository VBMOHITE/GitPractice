package vishwa.Com.vishwajit;

import java.io.IOException;
import java.util.ArrayList;

public class Sample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
Datadriven vb = new Datadriven();
 ArrayList data =vb.getData("Sales");
System.out.println(data.get(0));
System.out.println(data.get(1));
System.out.println(data.get(2));
System.out.println(data.get(3));
//System.out.println(data.get(4));

	}

}
