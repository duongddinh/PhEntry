@echo off 
echo compile java files...
javac src/*java
echo make it to .jar...
jar cvfm LogInForm.jar manifest.txt src/*.class Logo.png Nice1.gif sound.wav
echo deleting *.class ..
del src/*class
echo done!
pause