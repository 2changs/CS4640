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
import java.util.Date;
import java.util.Properties;

public class contact extends HttpServlet
{
 // This is a bogus email created for this example

 // By default Gmail account is highly secured. When we use gmail smtp from non gmail tool, email is blocked.
 // To allow any program (e.g., this servlet) to login and send email from a gmail account,
 // please go to the gmail account >> sign-in and security >> turn on the "less security" option
 // (https://myaccount.google.com/lesssecureapps).

 private String username = "AmandaDianawebpl";   // ask me for username and password used for this example
 private String password = "webplisfun";

 private String from_email = "manda.nguyen@gmail.com";
 private String to_email = "amandadianawebpl@gmail.com";

 private String str_cofm = "";

 protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
 {
    res.setContentType ("text/html");
    PrintWriter out = res.getWriter ();

    String your_email = req.getParameter("email");
    String email_subj = "Email from " + req.getParameter("name");
    String email_msg = req.getParameter("message");
    String phone = req.getParameter("phone");
    String nameofsender = req.getParameter("name");
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
				out.println("<nav class=\"navbar navbar-default\">");
				    out.println("<div class=\"navbar-header\">");
				        out.println("<button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#bs-example-navbar-collapse-1\">");
		                    out.println("<span class=\"sr-only\">Toggle navigation</span>");
		                    out.println("<span class=\"icon-bar\"></span>");
		                    out.println("<span class=\"icon-bar\"></span>");
		                    out.println("<span class=\"icon-bar\"></span>");
		                out.println("</button>");
				      out.println("<a class=\"navbar-brand\" href=\"index.html\"><img class=\"logo\" src=\"./images/logo1.png\"/ alt=\"logo\"></a>");
				    out.println("</div>");
				    out.println("<div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\">");
					    out.println("<ul class=\"nav navbar-nav navbar-right\">");
					      out.println("<li><a href=\"recipes.html\">Recipes</a></li>");
					      out.println("<li><a href=\"submitRecipe.html\">Submit</a></li>");
					      out.println("<li><a href=\"contact.html\">Contact Us</a></li>");
					      out.println("<li><a href=\"signin.php\">Sign In</a></li>");
					    out.println("</ul>");
					out.println("</div>");
				out.println("</nav>");


				out.println("<div class=\"about\">");
					out.println("<div id=\"diana\" class=\"person\">");
						out.println("<div class=\"person-img-container\">");
							out.println("<img class=\"person-img\" src=\"./images/diana.png\" alt=\"\" />");
							out.println("<p class=\"person-name\"> Diana Chang </p>");
						out.println("</div>");
						out.println("<div class=\"person-desc\">");
							out.println("Hi, I'm Diana! I'm a 3rd year BSCS student and I love Web PL!!!!!");
						out.println("</div>");
					out.println("</div>");
					out.println("<div id=\"amanda\" class=\"person\">");
						out.println("<div class=\"person-img-container\">");
							out.println("<img class=\"person-img\" src=\"./images/amanda.jpg\" alt=\"\" />");
							out.println("<p class=\"person-name\">Amanda Nguyen</p>");
						out.println("</div>");
						out.println("<div class=\"person-desc\">");
							out.println("Hi everyone! My name is Amanda Nguyen and I'm a student at the University of Virginia majoring in Computer Science. In my free time I like to play volleyball with my friends and eat my way around Charlottesville!");
						out.println("</div>");
					out.println("</div>");
				out.println("</div>");

				out.println("<div class=\"form\">");
					out.println("<form name=\"form-contact\" action=\"http://localhost:8080/appetize/contact\" method=\"post\">");
				    	out.println("<label for=\"contact-name\"> Name: </label>");
							out.println("<input type=\"text\" name=\"name\" class=\"form-control\" size=30 placeholder=\"Name\">");
						out.println("<span class=\"error\" id=\"error-name\"> </span> </br>");

						out.println("<label for=\"email\"> Email: </label>");
						out.println("<input type=\"text\" name=\"email\" class=\"form-control\" size=30 placeholder=\"Email\"");
						out.println("<span class=\"error\" id=\"error-email\"> </span> </br>");

						out.println("<label for=\"phone\"> Phone: </label>");
						//pattern=\"(?:\(\d{3}\)|\d{3})[- ]?\d{3}[- ]?\d{4}\"
				     out.println("        <input type=\"text\" class=\"form-control\" name=\"phone\" size=30 placeholder=\"Phone\">");
						out.println("<span class=\"error\" id=\"error-phone\"> </span> </br>");

						out.println("<label for=\"message\"> Message: </label>");
						out.println("<textarea name=\"message\" class=\"form-control\" rows=\"5\" placeholder=\"Please enter your message here\"></textarea>");
						out.println("<span class=\"error\" id=\"error-message\"> </span>");
						out.println("<br/>");
						out.println("<input type =\"submit\" value=\"Submit\" class=\"btn btn-submit\" onclick=\"validate()\"/>");
			  		out.println("</form>");
			  	out.println("</div>");
				out.println("<footer>");
					out.println("CS4753 | Diana Chang | Amanda Nguyen");
				out.println("</footer>");
			out.println("</body>");
		out.println("</html>");

		send_email(your_email, email_subj, email_msg, phone);
    // out.println("<html>");
    // out.println("<head>\n <title>Appetize</title>\n</head>");
    // out.println("<body>");
    // out.println("  <h1>"+"Hi "+ nameofsender+", " + "your message has been sent.</title></h1>");
    //

    // //out.println(str_cofm);    // print confirmation
    //
    // out.print ("</body>\n");
    // out.print ("</html>\n");

    out.close ();
 }

 protected void doGet(HttpServletRequest req, HttpServletResponse res)
		     throws ServletException, IOException
 {
    res.setContentType ("text/html");
    PrintWriter out = res.getWriter();

	 HttpSession session = req.getSession(true);
	 Date time = new Date(session.getCreationTime());

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
				out.println("<nav class=\"navbar navbar-default\">");
				    out.println("<div class=\"navbar-header\">");
				        out.println("<button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#bs-example-navbar-collapse-1\">");
		                    out.println("<span class=\"sr-only\">Toggle navigation</span>");
		                    out.println("<span class=\"icon-bar\"></span>");
		                    out.println("<span class=\"icon-bar\"></span>");
		                    out.println("<span class=\"icon-bar\"></span>");
		                out.println("</button>");
				      out.println("<a class=\"navbar-brand\" href=\"index.html\"><img class=\"logo\" src=\"./images/logo1.png\"/ alt=\"logo\"></a>");
				    out.println("</div>");
				    out.println("<div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\">");
					    out.println("<ul class=\"nav navbar-nav navbar-right\">");
					      out.println("<li><a href=\"recipes.html\">Recipes</a></li>");
					      out.println("<li><a href=\"submitRecipe.html\">Submit</a></li>");
					      out.println("<li><a href=\"contact.html\">Contact Us</a></li>");
					      out.println("<li><a href=\"signin.php\">Sign In</a></li>");
					    out.println("</ul>");
					out.println("</div>");
				out.println("</nav>");


				out.println("<div class=\"about\">");
					out.println("<div id=\"diana\" class=\"person\">");
						out.println("<div class=\"person-img-container\">");
							out.println("<img class=\"person-img\" src=\"./images/diana.png\" alt=\"\" />");
							out.println("<p class=\"person-name\"> Diana Chang </p>");
						out.println("</div>");
						out.println("<div class=\"person-desc\">");
							out.println("Hi, I'm Diana! I'm a 3rd year BSCS student and I love Web PL!!!!!");
						out.println("</div>");
					out.println("</div>");
					out.println("<div id=\"amanda\" class=\"person\">");
						out.println("<div class=\"person-img-container\">");
							out.println("<img class=\"person-img\" src=\"./images/amanda.jpg\" alt=\"\" />");
							out.println("<p class=\"person-name\">Amanda Nguyen</p>");
						out.println("</div>");
						out.println("<div class=\"person-desc\">");
							out.println("Hi everyone! My name is Amanda Nguyen and I'm a student at the University of Virginia majoring in Computer Science. In my free time I like to play volleyball with my friends and eat my way around Charlottesville!");
						out.println("</div>");
					out.println("</div>");
				out.println("</div>");

				out.println("<div class=\"form\">");
					out.println("<form name=\"form-contact\" action=\"http://localhost:8080/appetize/contact\" method=\"post\">");
				    	out.println("<label for=\"contact-name\"> Name: </label>");
							out.println("<input type=\"text\" name=\"name\" class=\"form-control\" size=30 placeholder=\"Name\">");
						out.println("<span class=\"error\" id=\"error-name\"> </span> </br>");

						out.println("<label for=\"email\"> Email: </label>");
						out.println("<input type=\"text\" name=\"email\" class=\"form-control\" size=30 placeholder=\"Email\"");
						out.println("<span class=\"error\" id=\"error-email\"> </span> </br>");

						out.println("<label for=\"phone\"> Phone: </label>");
						//pattern=\"(?:\(\d{3}\)|\d{3})[- ]?\d{3}[- ]?\d{4}\"
				     out.println("        <input type=\"text\" class=\"form-control\" name=\"phone\" size=30 placeholder=\"Phone\">");
						out.println("<span class=\"error\" id=\"error-phone\"> </span> </br>");

						out.println("<label for=\"message\"> Message: </label>");
						out.println("<textarea name=\"message\" class=\"form-control\" rows=\"5\" placeholder=\"Please enter your message here\"></textarea>");
						out.println("<span class=\"error\" id=\"error-message\"> </span>");
						out.println("<br/>");
						out.println("<input type =\"submit\" value=\"Submit\" class=\"btn btn-submit\" onclick=\"validate()\"/>");
			  		out.println("</form>");
			  	out.println("</div>");
				out.println("<footer>");
					out.println("CS4753 | Diana Chang | Amanda Nguyen");
				out.println("</footer>");
			out.println("</body>");
		out.println("</html>");

		out.close();
 }


 private void send_email(String email_address, String email_subject, String email_message, String phone)
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
          message.setContent(email_message + "\n" + phone, "text/html; charset=utf-8");   // set a message of an email


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
