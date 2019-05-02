# Project-5

This project had many components where I gained experience with constructing buttons, text fields, label, scrollers, drop downs, files, and action listeners. 

I started out this project by simply setting the layout out the Frame and components of the frame. I didn't use any layout managers so I set the bounds of each component individually. I set up each text field and set the one's that held the stations, and the hamming distances to not be editable. I then set up all the buttons that were associated with the specific text areas. After I set up the buttons I set the drop down and slider. The drop down I read in the file into an array list and  put it into the drop down. 

I then added action listeners to all the components of the frame. I set the action listener for the slider to set the text of the enter hamming distance text area. For the show stations button I used a loop and an arrayList to fill the text area under the button. With calculate HD I used my code from a previous project ot calculate the Hamming Distance and I calculated it between the arrayList[index] and the value in the drop down. Variables were then incremented depending on whether the HD was equal to 1, 2, 3, or 4. I set these variables to set the text of their specific text areas. The add Station button just added the station in the text area to the list in the drop box. 

When it came to the creative portion of the project I created a component that would add or delete stations in a drop down. In this component I read the stations into the drop down the same way I did before. I created a text area that the buttons would go off of. The add button would add the station if it was not already in the drop down. The delete button would delete the station if it did reside in the drop down. The next component I created was a scroller that would return a certain index. I set this index equal to the same index of the array list that held the contents of the file. Within the textbox I calculated the hamming distance between the element in the drop down and the element at the index according to the index provided by scroller. 

Working through all of this was such a fun project to work on. I had fun working on the design of the frame but also creating action listeners for the problem. 


<img width="193" alt="Project 5 UML" src="https://user-images.githubusercontent.com/47228127/57093546-d93c0780-6cd3-11e9-894f-709e7c5cde3b.png">
