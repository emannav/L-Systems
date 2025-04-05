# Lindenmayer Systems Project Diary

### Entry 18 - April 5<sup>th</sup>
I have been attempting to work with LazyGui, but it is not proving very effective. I attempted to begin with the most basic 
code for it to get an idea of whether it would even be functional and it did. It worked for a simple output. I decided I 
would begin slowly integrated parts of the actual graphical output from there but nothing I try is working with my code setup. 
I have used the IntelliJ-specific examples given by KrabCode, the author of LazyGui, with no success. While the initial attempt 
proved functional, I have seen no progress since. I have attempted multiple different ways of implementation, going so far as 
to restructure part of my code, but I am stuck with a consistent error that keeps the code from running. At one point I got 
it to create a window, but it would still not create a render, only a blank window. It is so late into the process to make 
significant changes that I am hesitant to stop trying and move to yet another GUI framework. I will be back at step 1 again 
no matter what framework I switch over to. I will keep trying for at least another day or two then reevaluate. I understand 
that I shouldn't have taken such a risk so late into the timeline, and I am struggling a bit with what could have gone 
differently if I had made different decisions, but I need to work on now with what I have.

### Entry 17 - March 22<sup>nd</sup>
I've been making additions to my report. I have not had a significant amount of time to work on the code due to multiple 
coursework submissions being very close together. I have continued working on Overleaf for my report as it remains the 
most convenient option for me. Additions to the report so far consist of the report-based deliverables discussing some 
further classifications of L-Systems I found in a research paper from a Springer Archive book *Lindenmayer Systems: Impacts 
on Theoretical Computer Science, Computer Graphics, and Developmental Biology*. The information is spread over a variety 
of topics, so I have had to go back and forth between a couple papers to understand which classifications are truly distinct 
and which ones overlap enough to disregard.

### Entry 16 - March 15<sup>th</sup>
I've been trying to produce a functional output as I want with G4P which is proving unsuccessful and not all the way 
compatible with the version of Processing that I am using. Exploring options once again with LazyGui, another library 
created for Processing. This one has more recent updates and appears to be compatible with Processing 4 and the readme 
includes some reference to integrating it into IntelliJ which I'm hoping means that I can implement it without too much 
trouble.

### Entry 15 - March 9<sup>th</sup>
After changing absolutely nothing in my code apart from writing it out in front of a friend, the Processing `redraw` function 
worked flawlessly, triggered by `mousePressed` which also did not work previously. I feel like I can't progress with JavaFX 
now. It feels like an insane drawback but if it works then it's a much more reasonable progression to stick to one library 
instead of integrating three separate things that aren't commonly or easily used together. This may affect the timeline but 
I'm behind anyway so I'll make up time where possible.<br>
This is frustrating and I feel like all the time I've spent trying to make Processing work has been wasted because the very 
first method I tried is now functional despite no change to the rest of the code. Keep calm and carry on, I suppose. 

### Entry 14 - Feb 28th<sup>th</sup>
I've not had a very productive month in the context of this project. I'm going to begin shifting to JavaFX from now. I 
plan to work on some base stochastic implementation before that, so I at least have something to show with the Processing 
sketches still. The issue with continuing with Processing now is that G4P and its corresponding GUI Builder were created 
with the Processing IDE and its specific language (similar to Java but ultimately different) in mind. The resources available 
for it are extremely limited, and all discussion and community forums have the latest posts from 2014 or one or two from 2022. 
I started with Processing because the sketch mechanism with its pen functionalities are perfect for adapting turtle objects 
that achieve the desired graphics. I've been researching JavaFX, but didn't have the chance to add that progress to the 
diary. I hope to begin soon with implementation as soon as further stochastic implementation has proved successful.

### Entry 13 - Feb 4<sup>th</sup>
I couldn't carry out research over the winter break, but have been going through resources for G4P (GUI for Processing) 
to see if it will allow me to implement the functionalities I am aiming for. The resources are, however, quite limited 
and most of them are from 2014 and prior. As I am also using Processing as a library and not within its own IDE, I will 
have to adapt whatever implementation I find to fit into the Java programs I am using. JavaFX is still my backup, though 
beginning on that will also require a period of research.

### Entry 12 - Dec 3<sup>rd</sup>
I have functional graphics for Koch Curve, Koch Snowflake, and Sierpinski Triangle. There was some issue in developing since
Processing seems to not have any sort of delay that would allow one graphic to remain on the window for a set time before 
I can clear the screen and present the next one. Currently, compromised to have several iterations of each fractal so the 
progress of generations can be seen clearly with fractals of different complexities.<br>
I might consider shifting from Processing to JavaFX since that seems to be a more reasonable avenue now that I have a better 
understanding of both and what exact functionalities they provide me with. Simpler fractals are easy to portray via 
the PApplet class, but as I progress, I would prefer to have better control of the output window.

### Entry 11 - Dec 1<sup>st</sup>
I was right about where exactly the error was stemming from. Did a bit of testing to make sure the issue was sorted and 
added a validation method to make sure the input string doesn't have any undefined characters. <br>
If undefined characters did make it through via the rules somehow, it should still be fine since the switch case in 
Turtle simply moves on as the default. This may come in handy if I end up taking user input later in term 2.

### Entry 10 - Nov 29<sup>th</sup>
Attempted first LSystem implementation, not yet functional. I think there's some issue with the way the strings are being 
generated. I might need to change how I'm storing the rules. List might be better since there's separate components of the 
Rule objects that I need to access constantly. Maybe iterating by index might help. List.get() would be convenient for it.

### Entry 09 - Nov 27<sup>th</sup>
I had some issues importing Processing as a library but managed a functional setup page extending PApplet. I've made a 
Turtle class to determine the initial default functionality of the turtle object. This will be the pen that determines 
sketch with the use of specific parameters. Some trial and error will be required to accurately implement fractal graphics.<br>
I am considering adding a coded demonstration of the String multiplication but am unsure if it would be useful. I will 
have an example like this in my report regardless.

### Entry 08 - Nov 23<sup>rd</sup>
Begun implementation of code. I've decided to use the processing library, so I can implement Turtle graphics as this is 
the most researched and easy to understand method in building functional L-systems.

### Entry 07 - Oct 26<sup>th</sup>
I have added the LaTeX files for the project plan to the repo and have begun drafting the report.

### Entry 06 - Oct 15<sup>th</sup>
I have been unable to upload the LaTeX file for my project plan onto IntelliJ. For now the pdf version is up and I will
try again with LaTeX, but I am having issues with TeXiFy-IDEA despite having the necessary plugins. I will remove the
pdf from the repo once the LaTeX issue is sorted as I edit those documents via Overleaf.<br>
I have been reading *The Algorithmic Beauty of Plants* and the above-mentioned *Lindenmayer Systems, Fractals, and Plants*
to get some reference on how to best show the working of the rewriting system.

### Entry 05 - Oct 11<sup>th</sup>
Final draft of project plan completed and submitted. Java Swing and Processing noted as potential libraries for GUI;
further research required. Had issues adding latex files to project repo, will attempt again later.<br>

### Entry 04 - Oct 9<sup>th</sup>
First draft completed and reviewed by supervisor. Begun edits.<br>

### Entry 03 - Oct 7<sup>th</sup>
First draft of project plan underway, expected completion by Tuesday afternoon for supervisor review.<br>

### Entry 02 - Oct 3<sup>rd</sup>
Started on book *The Algorithmic Beauty of Plants* and further related resources through *algorithmicbotany.org*<br>
Noting *On the Evolution of Parametric L-systems* and
*[Lindenmayer Systems, Fractals, and Plants](https://books.google.co.uk/books?hl=en&lr=&id=J6fxBwAAQBAJ&oi=fnd&pg=PA3&dq=lindenmayer+system&ots=1M7z5hbHbM&sig=AGGVYQDI6FbhdFSgg0flMhAvkkk)*
as next sources to explore.<br>
Meeting with supervisor, discussed expectations for the project plan and questions about final project deliverables.

### Entry 01 - Oct 2<sup>nd</sup>
I have an outline of the project plan set. Looked into research I can site. Found several helpful tutorials for guidance
 as well as a couple books and papers. Current research avenues: refseek, Semantic Scholar, Google Scholar.<br>



<br><br>
#### General refs 
[Stochastic L-system inference from multiple string sequence inputs](https://www.semanticscholar.org/paper/Stochastic-L-system-inference-from-multiple-string-Bernard-McQuillan/e92bf6640b1cdfc3155622274274bca4dc7593ec)<br>
[L-system models for image-based phenomics: case studies of maize and canola
](https://www.semanticscholar.org/paper/L-system-models-for-image-based-phenomics%3A-case-of-Cieslak-Khan/9c3a7ca6590928c8ec25f8246c1828d5311fa6f8) - specific plant mimics<br>
[Interactive Evolution of L-System Grammars for Computer Graphics Modelling](https://users.monash.edu/~jonmc/research/Papers/L-systems-evol.pdf)<br>
[Alvy Ray Smith Computer Graphics Papers](http://alvyray.com/Papers/PapersCG.htm) 

