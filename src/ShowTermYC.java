import java.awt.BorderLayout;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;

public class ShowTermYC extends EssentialFunctions{
	private static final long serialVersionUID = 1L;
	static JScrollPane scrollPane ;
	public static void close() {
		frame.getContentPane().remove(scrollPane);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);	
		frame.revalidate();
		frame.repaint();

	}
	
	public static void doit() {
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				JEditorPane jEditorPane = new JEditorPane();
				jEditorPane.setEditable(false);
				scrollPane = new JScrollPane(jEditorPane);
				HTMLEditorKit kit = new HTMLEditorKit();
				StyleSheet styleSheet = kit.getStyleSheet();
				if(Boolean.parseBoolean(getFistLine("/nightmode.txt"))) {
				styleSheet.addRule("body { background-color :#00000;}");
				styleSheet.addRule("h1 {color: #ffffff;}");
				styleSheet.addRule("h2 {color: #ffffff;}");
				styleSheet.addRule("p {color: #ffffff;}");
				styleSheet.addRule("ul {color: #ffffff;}");
				styleSheet.addRule("li {color: #ffffff;}");
				styleSheet.addRule("h3 { color: red;}");

				} else {
					styleSheet.addRule("body { background-color :#ffffff;}");
					styleSheet.addRule("h1 {color: #000000;}");
					styleSheet.addRule("h2 {color: #000000;}");
					styleSheet.addRule("p {color:#000000;}");
					styleSheet.addRule("ul {color: #000000;}");
					styleSheet.addRule("li {color:#000000;}");
					styleSheet.addRule("h3 {  color: red;}");

				}
				jEditorPane.setEditorKit(kit);
				String htmlString = "<html>\n"
						+ "<body>\n"
						+ "<h1>Terms and Conditions for NiceUI</h1>\n" + 
						"\n" + 
						"<h2>Introduction</h2> \n" + 
						"  \n" + 
						"<p><h3>The terms and conditions is here just to over-engineer the program,<br> but it is important to understand that the program will generate 9 txt files in its current directory to store data.<br>The login here is just for fun to browse r/programmerhumor reddit;<br> please don't use your actual reddit username and password. The password will NOT be sent to the server, it is stored locally<br> That is it! you can ignore the rest of the terms and conditions.</h3></p>"+
						"\n" +
						"<p>These Website Standard Terms and Conditions written on this webpage shall manage your use of our website; it is accessible at github.</p>\n" + 
						"\n" + 
						"<p>These Terms will be applied fully and affect to your use of this Website.<br> By using this Website, you agreed to accept all terms and conditions written in here. <br>You must not use this Website if you disagree with any of these Website Standard Terms and Conditions. <br>These Terms and Conditions have been generated with the help of the <a href=\"https://www.termsandcondiitionssample.com\">Terms And Conditions Template</a>.</p>\n" + 
						"\n" + 
						"<p>Everybody is allowed to use this Website.</p>\n" + 
						"\n" + 
						"<h2>Intellectual Property Rights</h2>\n" + 
						"\n" + 
						"<p>Other than the content you own, under these Terms, <br>NiceUI and/or its licensors own all the intellectual property rights and materials contained in this Website.</p>\n" + 
						"\n" + 
						"<p>You are granted limited license only for purposes of viewing the material contained on this Website.</p>\n" + 
						"\n" + 
						"<h2>Restrictions</h2>\n" + 
						"\n" + 
						"<p>You are specifically restricted from all of the following:</p>\n" + 
						"\n" + 
						"<ul>\n" + 
						"    <li>publishing any Website material in any other media;</li>\n" + 
						"    <li>selling, sublicensing and/or otherwise commercializing any Website material;</li>\n" + 
						"    <li>publicly performing and/or showing any Website material;</li>\n" + 
						"    <li>using this Website in any way that is or may be damaging to this Website;</li>\n" + 
						"    <li>using this Website in any way that impacts user access to this Website;</li>\n" + 
						"    <li>using this Website contrary to applicable laws and regulations,<br> or in any way may cause harm to the Website, or to any person or business entity;</li>\n" + 
						"    <li>engaging in any data mining, data harvesting, data extracting or any other similar activity in relation to this Website;</li>\n" + 
						"    <li>using this Website to engage in any advertising or marketing.</li>\n" + 
						"</ul>\n" + 
						"\n" + 
						"<p>Certain areas of this Website are restricted from being access by you <br>and NiceUI may further restrict access by you to any areas of this Website, at any time, in absolute discretion. <br>Any user ID and password you may have for this Website are confidential and you must maintain confidentiality as well.</p>\n" + 
						"\n" + 
						"<h2>Your Content</h2>\n" + 
						"\n" + 
						"<p>In these Website Standard Terms and Conditions, <br> \"Your Content\" shall mean any audio, video text, images or other material you choose to display on this Website.<br> By displaying Your Content, you grant NiceUI a non-exclusive, <br>worldwide irrevocable, sub licensable license to use, reproduce, adapt, publish, translate and distribute it in any and all media.</p>\n" + 
						"\n" + 
						"<p>Your Content must be your own and must not be invading any third-party’s rights.<br> NiceUI reserves the right to remove any of Your Content from this Website at any time without notice.</p>\n" + 
						"\n" + 
						"<h2>Your Privacy</h2>\n" + 
						"\n" + 
						"<p>Please read Privacy Policy.</p>\n" + 
						"\n" + 
						"<h2>No warranties</h2>\n" + 
						"\n" + 
						"<p>This Website is provided \"as is,\" with all faults, <br> and NiceUI express no representations or warranties, of any kind related to this Website or the materials contained on this Website. <br>Also, nothing contained on this Website shall be interpreted as advising you.</p>\n" + 
						"\n" + 
						"<h2>Limitation of liability</h2>\n" + 
						"\n" + 
						"<p>In no event shall NiceUI, nor any of its officers, directors and employees, shall be held liable for anything arising out of <br> or in any way connected with your use of this Website whether such liability is under contract. <br> NiceUI, including its officers, directors and employees shall not be held liable for any indirect, consequential <br> or special liability arising out of or in any way related to your use of this Website.</p>\n" + 
						"\n" + 
						"<h2>Indemnification</h2>\n" + 
						"\n" + 
						"<p>You hereby indemnify to the fullest extent NiceUI from and against any and/or all liabilities, costs, demands, causes of action, <br>damages and expenses arising in any way related to your breach of any of the provisions of these Terms.</p>\n" + 
						"\n" + 
						"<h2>Severability</h2>\n" + 
						"\n" + 
						"<p>If any provision of these Terms is found to be invalid under any applicable law,<br> such provisions shall be deleted without affecting the remaining provisions herein.</p>\n" + 
						"\n" + 
						"<h2>Variation of Terms</h2>\n" + 
						"\n" + 
						"<p>NiceUI is permitted to revise these Terms at any time as it sees fit, <br> and by using this Website you are expected to review these Terms on a regular basis.</p>\n" + 
						"\n" + 
						"<h2>Assignment</h2>\n" + 
						"\n" + 
						"<p>The NiceUI is allowed to assign, transfer, and subcontract its rights and/or obligations under these Terms without any notification.<br> However, you are not allowed to assign, transfer, or subcontract any of your rights and/or obligations under these Terms.</p>\n" + 
						"\n" + 
						"<h2>Entire Agreement</h2>\n" + 
						"    \n" + 
						"<p>These Terms constitute the entire agreement between NiceUI and you in relation to your use of this Website, <br>and supersede all prior agreements and understandings.</p>\n" + 
						"\n" + 
						"<h2>Governing Law & Jurisdiction</h2>\n" + 
						"\n" + 
						"<p>These Terms will be governed by and interpreted in accordance with the laws of the State of us, <br>and you submit to the non-exclusive jurisdiction of the state and federal courts located in us for the resolution of any disputes.</p>"
						+ "</body>\n";
				Document doc = kit.createDefaultDocument();
				jEditorPane.setDocument(doc);
				jEditorPane.setText(htmlString);
				SuperGoodUI.frame.getContentPane().add(scrollPane, BorderLayout.WEST);
				SuperGoodUI.frame.setLocationRelativeTo(null);
				SuperGoodUI.frame.setVisible(true);		  
				}
		});
	}
}
