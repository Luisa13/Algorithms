# Tips for this sort of exercises
These exercises are based on Object Oriented Design, and the goal is not to get a brilliant technical level with some super complicated algorithms, but to give an insight of the coding style and demostrate that you understand the problem.
This sort of exercises could be addressed in the same way pretty much, taking into accout (in my opinion) the next:


 ### Foresee the most usuall situation with the system you are given to desing. 
 This will give you an overview of the main system functionality. 
 If it does not cover everything, is a good starting point. Which actions will take place? What are the actors involved?
 
 ### Define core object
 Once you got such overview, identify the core objects and define their relationships. Do I need an object for _that_ or it's just an attribute?
 
 ### Indetify the most frequent actions with the data structures
 I think this is a really important point to get a decent design since is a game changer. If I need a bounch of items, what am I going to do with them? Am I going to add and remove them frequently? then maybe a list is a good candidate, how the system will access the data? Will it get items only from the top, randomly or in a certain order? Will I need to search them often?...
 You don't want to get a _funcionalish_ desing that is VERY inefficient.
 
 ### Draw and test main actions
 Investigate the acctions you just defined, playing around with the objects and the data structures before getting hands on. You might realize some things could have done better, or does not work in the way you thought in the first place.
