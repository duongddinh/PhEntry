import java.awt.BorderLayout;

import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLEditorKit;

public class ShowPrivacyPo extends EssentialFunctions {
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
				jEditorPane.setEditorKit(kit);
				String htmlString = "<html>\n"
						+ "<body>\n"
						+ "<h1>Privacy Policy</h1>\n" + 
						"\n" + 
						"\n" + 
						"<p>Effective date: August 03, 2019</p>\n" + 
						"\n" + 
						"\n" + 
						"<p>NiceUI (\"us\", \"we\", or \"our\") operates the bob.bob website and the NiceUI mobile application (the \"Service\").</p>\n" + 
						"\n" + 
						"<p>This page informs you of our policies regarding the collection, use, and disclosure of personal data when you use our Service <br>and the choices you have associated with that data. <br>Our Privacy Policy  for NiceUI is created with the help of the <a href=\"https://www.freeprivacypolicy.com/free-privacy-policy-generator.php\">Free Privacy Policy Generator</a>.</p>\n" + 
						"\n" + 
						"<p>We use your data to provide and improve the Service. <br>By using the Service, you agree to the collection and use of information in accordance with this policy.<br> Unless otherwise defined in this Privacy Policy, terms used in this Privacy Policy have the same meanings as in our Terms and Conditions.</p>\n" + 
						"\n" + 
						"\n" + 
						"<h2>Information Collection And Use</h2>\n" + 
						"\n" + 
						"<p>We collect several different types of information for various purposes to provide and improve our Service to you.</p>\n" + 
						"\n" + 
						"<h3>Types of Data Collected</h3>\n" + 
						"\n" + 
						"<h4>Personal Data</h4>\n" + 
						"\n" + 
						"<p>While using our Service, we may ask you to provide us with certain<br> personally identifiable information that can be used to contact or identify you (\"Personal Data\").<br> Personally identifiable information may include, but is not limited to:</p>\n" + 
						"\n" + 
						"<ul>\n" + 
						"<li>First name and last name</li><li>Cookies and Usage Data</li>\n" + 
						"</ul>\n" + 
						"\n" + 
						"<h4>Usage Data</h4>\n" + 
						"\n" + 
						"<p>We may also collect information that your browser sends whenever you visit our Service <br> or when you access the Service by or through a mobile device (\"Usage Data\").</p>\n" + 
						"<p>This Usage Data may include information such as your computer's Internet Protocol address <br>(e.g. IP address), browser type, browser version, the pages of our Service that you visit, <br>the time and date of your visit, the time spent on those pages, unique device identifiers and other diagnostic data.</p>\n" + 
						"<p>When you access the Service by or through a mobile device, this Usage Data may include information such as the type <br>of mobile device you use, your mobile device unique ID,<br> the IP address of your mobile device, your mobile operating system, <br>the type of mobile Internet browser you use, unique device identifiers and other diagnostic data.</p>\n" + 
						"\n" + 
						"<h4>Tracking & Cookies Data</h4>\n" + 
						"<p>We use cookies and similar tracking technologies to track the activity on our Service and hold certain information.</p>\n" + 
						"<p>Cookies are files with small amount of data which may include an anonymous unique identifier. <br>Cookies are sent to your browser from a website and stored on your device.<br> Tracking technologies also used are beacons, tags, and scripts to collect and track information and to improve and analyze our Service.</p>\n" + 
						"<p>You can instruct your browser to refuse all cookies or to indicate when a cookie is being sent. <br>However, if you do not accept cookies, you may not be able to use some portions of our Service.</p>\n" + 
						"<p>Examples of Cookies we use:</p>\n" + 
						"<ul>\n" + 
						"    <li><strong>Session Cookies.</strong> We use Session Cookies to operate our Service.</li>\n" + 
						"    <li><strong>Preference Cookies.</strong> We use Preference Cookies to remember your preferences and various settings.</li>\n" + 
						"    <li><strong>Security Cookies.</strong> We use Security Cookies for security purposes.</li>\n" + 
						"</ul>\n" + 
						"\n" + 
						"<h2>Use of Data</h2>\n" + 
						"    \n" + 
						"<p>NiceUI uses the collected data for various purposes:</p>    \n" + 
						"<ul>\n" + 
						"    <li>To provide and maintain the Service</li>\n" + 
						"    <li>To notify you about changes to our Service</li>\n" + 
						"    <li>To allow you to participate in interactive features of our Service when you choose to do so</li>\n" + 
						"    <li>To provide customer care and support</li>\n" + 
						"    <li>To provide analysis or valuable information so that we can improve the Service</li>\n" + 
						"    <li>To monitor the usage of the Service</li>\n" + 
						"    <li>To detect, prevent and address technical issues</li>\n" + 
						"</ul>\n" + 
						"\n" + 
						"<h2>Transfer Of Data</h2>\n" + 
						"<p>Your information, including Personal Data, may be transferred to — and maintained on — computers located outside <br>of your state, province, country<br> or other governmental jurisdiction where the data protection laws may differ than those from your jurisdiction.</p>\n" + 
						"<p>If you are located outside United States and choose to provide information to us, please note that we transfer the data,<br> including Personal Data,<br> to United States and process it there.</p>\n" + 
						"<p>Your consent to this Privacy Policy followed by your submission of such information represents your agreement to that transfer.</p>\n" + 
						"<p>NiceUI will take all steps reasonably necessary to ensure that your data is treated securely<br> and in accordance with this Privacy Policy and no transfer of your Personal Data will take place <br> to an organization or a country unless there are adequate controls in place including the security of<br> your data and other personal information.</p>\n" + 
						"\n" + 
						"<h2>Disclosure Of Data</h2>\n" + 
						"\n" + 
						"<h3>Legal Requirements</h3>\n" + 
						"<p>NiceUI may disclose your Personal Data in the good faith belief that such action is necessary to:</p>\n" + 
						"<ul>\n" + 
						"    <li>To comply with a legal obligation</li>\n" + 
						"    <li>To protect and defend the rights or property of NiceUI</li>\n" + 
						"    <li>To prevent or investigate possible wrongdoing in connection with the Service</li>\n" + 
						"    <li>To protect the personal safety of users of the Service or the public</li>\n" + 
						"    <li>To protect against legal liability</li>\n" + 
						"</ul>\n" + 
						"\n" + 
						"<h2>Security Of Data</h2>\n" + 
						"<p>The security of your data is important to us, but remember that no method of transmission over the Internet, <br>or method of electronic storage is 100% secure. <br>While we strive to use commercially acceptable means to protect your Personal Data, we cannot guarantee its absolute security.</p>\n" + 
						"\n" + 
						"<h2>Service Providers</h2>\n" + 
						"<p>We may employ third party companies and individuals to facilitate our Service (\"Service Providers\"),<br> to provide the Service on our behalf, to perform Service-related services or to assist us in analyzing how our Service is used.</p>\n" + 
						"<p>These third parties have access to your Personal Data only to perform these tasks on our behalf <br> and are obligated not to disclose or use it for any other purpose.</p>\n" + 
						"\n" + 
						"\n" + 
						"\n" + 
						"<h2>Links To Other Sites</h2>\n" + 
						"<p>Our Service may contain links to other sites that are not operated by us. <br>If you click on a third party link, you will be directed to that third party's site.<br> We strongly advise you to review the Privacy Policy of every site you visit.</p>\n" + 
						"<p>We have no control over and assume no responsibility for the content, privacy policies or practices of any third party sites or services.</p>\n" + 
						"\n" + 
						"\n" + 
						"<h2>Children's Privacy</h2>\n" + 
						"<p>Our Service does not address anyone under the age of 18 (\"Children\").</p>\n" + 
						"<p>We do not knowingly collect personally identifiable information from anyone under the age of 18. <br>If you are a parent or guardian and you are aware that your Children has provided us with Personal Data, <br>please contact us.<br> If we become aware that we have collected Personal Data from children without verification of parental consent,<br> we take steps to remove that information from our servers.</p>\n" + 
						"\n" + 
						"\n" + 
						"<h2>Changes To This Privacy Policy</h2>\n" + 
						"<p>We may update our Privacy Policy from time to time. We will notify you of any changes by posting the new Privacy Policy on this page.</p>\n" + 
						"<p>We will let you know via email and/or a prominent notice on our Service,<br> prior to the change becoming effective and update the \"effective date\" at the top of this Privacy Policy.</p>\n" + 
						"<p>You are advised to review this Privacy Policy periodically for any changes. <br>Changes to this Privacy Policy are effective when they are posted on this page.</p>\n" + 
						"\n" + 
						"\n" + 
						"<h2>Contact Us</h2>\n" + 
						"<p>If you have any questions about this Privacy Policy, please contact us:</p>\n" + 
						"<ul>\n" + 
						"        <li>By email: bob@bob.bob</li>\n" + 
						"            <li>By visiting this page on our website: bob.bob</li>\n" + 
						"      \n" + 
						"        </ul>"
						+ "</body>\n";
				Document doc = kit.createDefaultDocument();
				jEditorPane.setDocument(doc);
				jEditorPane.setText(htmlString);
				frame.getContentPane().add(scrollPane, BorderLayout.WEST);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);		  
				}
		});
	}
}
