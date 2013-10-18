package com.cdac.svarn.web.accountmgmt;
import java.io.PrintWriter;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ChartServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest requestObj, HttpServletResponse responseObj) 
	{


		try{
			//System.out.println(" servlet me aa gaya");

			String p=requestObj.getParameter("principle");
			String r=requestObj.getParameter("rate");
			String in=requestObj.getParameter("installment");

			
		//	System.out.println(p+"received object  --"+in+"---------------- "+r);
			Double principle=Double.parseDouble(p);
			Double rate=Double.parseDouble(r);
			Double installment=Double.parseDouble(in);
			Double interest=0.0;

			//System.out.println("received object  ------------------ "+principle);
			int i=1;

			PrintWriter writer = responseObj.getWriter();


			writer.println("<table border=\"1\">");
			writer.println("<tr>");
			
			writer.println("<th> Month");

			writer.println("</th>");

			writer.println("<th> Interest");
			writer.println("</th>");

			writer.println("<th> Installment");
			writer.println("</th>");

			writer.println("<th> Balance");
			writer.println("</th>");
			writer.println("</tr>");



			writer.println("<tr>");

			writer.println("<td>");
			writer.println("0 month");

			writer.println("</td>");

			writer.println("<td>");
			writer.println("0");

			writer.println("</td>");

			writer.println("<td>");
			writer.println("0");

			writer.println("</td>");

			writer.println("<td>");
			writer.println(""+principle);

			writer.println("</td>");
			writer.println("</tr>");


			
			while(true){
				writer.println("<tr>");
				writer.println("<td>");
				writer.println(i+" month");
				writer.println("</td>");

				writer.println("<td>");
				interest=(principle*rate)/1200;
				int ix = (int)(interest * 100.0); // scale it
				interest = ((double)ix)/100.0;
				writer.println(""+interest);



				writer.println("</td>");

				writer.println("<td>");
				writer.println(""+installment);

				writer.println("</td>");

				writer.println("<td>");
				principle=principle+interest-installment;
				ix = (int)(principle * 100.0); // scale it
				principle = ((double)ix)/100.0;
				writer.println(""+principle);

				writer.println("</td>");

				writer.println("</tr>");
				i++;
				interest=(principle*rate)/1200;
				if((principle+interest)<installment){
					writer.println("<tr>");
					writer.println("<td>");
					writer.println(i+" month");
					writer.println("</td>");

					writer.println("<td>");
					interest=(principle*rate)/1200;
					ix = (int)(interest * 100.0); // scale it
					interest = ((double)ix)/100.0;
					writer.println(""+interest);



					writer.println("</td>");

					writer.println("<td>");
					principle=(principle+interest);
					ix = (int)(principle * 100.0); // scale it
					principle = ((double)ix)/100.0;
					writer.println(""+principle);

					writer.println("</td>");

					writer.println("<td>");
					writer.println("0");

					writer.println("</td>");
					
					writer.println("</tr>");
					break;

				}
			}

			

			writer.println("</table>");

			
		}
		catch(Exception e)
		{
			System.out.println("exception in servlet : "+e);
		}
	}  
}
