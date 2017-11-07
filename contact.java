package Assignment5;

//package examples;

//Import Servlet Libraries
//import javax.servlet.*;
//import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//import mail service libraries
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.PasswordAuthentication;

//Import Java Libraries
import java.io.*;
import java.util.Properties;

@WebServlet("/Assignment5")
public class contact extends HttpServlet 
{
 // This is a bogus email created for this example
	
 // By default Gmail account is highly secured. When we use gmail smtp from non gmail tool, email is blocked. 
 // To allow any program (e.g., this servlet) to login and send email from a gmail account,
 // please go to the gmail account >> sign-in and security >> turn on the "less security" option 
 // (https://myaccount.google.com/lesssecureapps). 
	
 private String username = "commanderamander11";   // ask me for username and password used for this example
 private String password = "oneshot1";
			
 private String from_email = "manda.nguyen@gmail.com";
 private String to_email = "commanderamander11@gmail.com";
	   
 private String str_cofm = "";
	
 protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
 {
    res.setContentType ("text/html");
    PrintWriter out = res.getWriter ();  
    
    String your_email = req.getParameter("contact-email");
    String email_subj = "hello";
    		//req.getParameter("email_subject");
    String email_msg = req.getParameter("contact-message");
                           
    out.println("<html>");
    out.println("<head>\n <title>CS 4640: Sending mail exercise</title>\n</head>");
    out.println("<body>");
    out.println("  <h1>CS 4640: Sending mail exercise</title></h1>");
    
    send_email(your_email, email_subj, email_msg);
    out.println(str_cofm);    // print confirmation 
    
    out.print ("</body>\n");
    out.print ("</html>\n");

    out.close ();	      
 }
 
 protected void doGet(HttpServletRequest req, HttpServletResponse res) 
		     throws ServletException, IOException 
 {	    	   
    res.setContentType ("text/html");
    PrintWriter out = res.getWriter();

    // always a good idea to include title --> telling where we are (in addition to what shows in the body)
    // and also increase usability when the url to this web component is bookmarked
    
//    out.println("<html>\n<head>\n <title>CS 4640: Sending mail exercise</title>\n</head>");      
//    out.println("<body>");
//    out.println("<center><h1>CS 4640: Sending mail exercise</h1></center>");
//    out.println("<form action=\"http://localhost:8080/example/Assignment5\" method=\"post\">");
//    out.println("<center>");
//    out.println("  <table>");
//    out.println("    <tr>");
//    out.println("      <td>");
//    out.println("        Email address ");
//    out.println("      </td>");
//    out.println("      <td>");          
//    out.println("        <input type=\"text\" name=\"your_email\" size=30>");
//    out.println("      </td>");
//    out.println("    </tr>");
//    out.println("    <tr>");
//    out.println("      <td>");
//    out.println("        Subject ");
//    out.println("      </td>");
//    out.println("      <td>");     
//    out.println("        <input type=\"text\" name=\"email_subject\" size=30>");
//    out.println("      </td>");
//    out.println("    </tr>");
//    out.println("    <tr>");
//    out.println("      <td>");
//    out.println("        Message ");
//    out.println("      </td>");
//    out.println("      <td>");     
//    out.println("        <input type=\"text\" name=\"email_msg\" size=30>");
//    out.println("      </td>");
//    out.println("    </tr>");
//    out.println("    <tr>");      
//    out.println("      <td align=\"center\" colspan=2>");     
//    out.println("        <input type=\"submit\" value=\"Send Email\">");
//    out.println("      </td>");
//    out.println("    </tr>");
//    out.println("  </table>");
//    out.println("</center>");
//    out.println("</form>");   
//   
//    out.println("</body>");
//    out.println("</html>");
    
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset=\"UTF-8\">");
    	out.println("<title>Appetize</title>");
    	out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"./css/style.css\">");
    	out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"./css/contact.css\">");

    	out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">");
    	out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>");
    	out.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>");
    	out.println("<script src=\"./js/index.js\"></script>");
    	out.println("</head>");
    	out.println("<body>");
    
    	out.println("<div class=\"form\">");
    	out.println("<form name=\"form-contact\" action = \"http://localhost:8080/example/Assignment5\" method=\"post\">");
    	out.println("<label for=\"contact-name\"> Name: </label>");
    	out.println("<input name=\"name\" class=\"form-control\" type = \"text\" id = \"contact-name\" placeholder=\"Name\" />");
    	out.println("<span class=\"error\" id=\"error-name\"> </span> </br>");

    	out.println("<label for=\"email\"> Email: </label>");
    	out.println("<input name=\"email\" class=\"form-control\" type = \"email\" id = \"contact-email\" placeholder=\"Email\"/>");
    	out.println("<span class=\"error\" id=\"error-email\"> </span> </br>");

    	out.println("<label for=\"phone\"> Phone: </label>");
    	out.println("<input name=\"phone\" class=\"form-control\" type = \"text\" id = \"contact-phone\" placeholder=\"Phone\"/>");
    	out.println("<span class=\"error\" id=\"error-phone\"> </span> </br>");

    	out.println("<label for=\"message\"> Message: </label>");
    	out.println("<textarea name=\"message\" class=\"form-control\" rows=\"5\" id=\"contact-message\" placeholder=\"Please enter your message here\"></textarea>");
    	out.println("<span class=\"error\" id=\"error-message\"> </span>");
    	out.println("<br/>");
    	out.println("<input type =\"button\" id =\"contact-submitbutton\" value=\"Submit\" class=\"btn btn-submit\"/>");
    	out.println("</form>");
	out.println("</div>");
	out.println("</body>");
	out.println("</html>");
//    
    out.close();
 }
 
 
 private void send_email(String email_address, String email_subject, String email_message)
 {
    Properties props = new Properties();
    
    // Specifies the IP address of your default mail server
	  // for example, if you are using gmail server as an email sever
    // you will pass smtp.gmail.com as value of mail.smtp host. 
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "587");      
    
   // pass properties object and authenticator object
   // for authentication to Session instance

    Session session = Session.getInstance(props, new javax.mail.Authenticator() {
          protected PasswordAuthentication getPasswordAuthentication() {
             return new PasswordAuthentication(username, password);
       }
    }); 
                
    if (email_address.length() > 0 && email_message.length() > 0)
    {
       try 
       {
          Message message = new MimeMessage(session);
          message.setFrom(new InternetAddress(from_email));     // from which email address
          message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to_email));  // send to which email address
          message.addRecipient(Message.RecipientType.TO, new InternetAddress(email_address));  // add more recipients
          message.setSubject(email_subject);         // set a subject of an email 
          message.setContent(email_message, "text/html; charset=utf-8");   // set a message of an email 
          
          Transport.send(message);                              
             
          // always provide feedback, so that the users know what happens, what to do next 
          
          str_cofm = "Email notification was sent";    // nothing wrong, confirm to the user so that the user knows the status
          
       } catch (MessagingException e) {
      	// if something's wrong, let the user knows  
          str_cofm = "There is a problem while sending an email. " + 
                     "Please check your code and try sending an email again."; 
          throw new RuntimeException(e);
       }
     }    
                
 }   
}

