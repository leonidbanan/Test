if u cocksucker please read next:

Precondition: 
1. Maven version 4.0.0 or higher
2. JDK 5.0 or higher
3. Junit 4.11 or higher

Installation :

Run : Edit config. --> Test kind: Class; Class: LogicTest


Test cases:

    positive :
  I.(Precondition -  door is closed)
    1. open the door
    2. close the door
    3. check that door is closed
     exp: false ( door is closed )

  II.(Precondition -  door is closed)
    1. open the door
    2. if room is empty, put in the room object
    3. check the room
    exp: NOT EMPTY

  III.(Precondition -  door is closed)
    1. open the door
    2. if room is empty, put in the room object
    3. remove object
    4. check the room
    exp: EMPTY

   IV.(Precondition -  door is closed)
   1. open the door
   2. if room is empty, put in the room object
   3. check the object in the room
   exp: true


    V.(Precondition -  door is closed)
    1. open the door
    2. if room is empty, put in the room object
    3. remove object
    4. check the object in the room
    exp: false

  negative :

  I.(Precondition -  door is closed)
    1. open the door
    2. open the door
     waiting for a Exception


  II.(Precondition -  door is closed)
    1. Try to find out if the door is closed, without opening the door
     waiting for a RoomClosedException


  III.(Precondition -  door is closed)
    1. open the door
    2. put in the room object
    3. put the object again
     waiting for a Exception that we have the object in the room

  IV.(Precondition -  door is closed)
    1.open the door
    2.remove the object from the empty room
     waiting for a Exception that we have no any object in the room


  V.(Precondition -  door is closed)
    1. add the object
    waiting for a RoomClosedException




