package dataStructures.impl.linkedList

import dataStructures.impl.Node

class LinkedList {
  var head : Node = null

  // Initialize LinkedList
  def initialize(data: Int) : Unit = {
    if(head == null){
      val newNode : Node = new Node(data)
      head = newNode
    }
  }

  // Print the LinkedList
  def printList() : Unit = {
    var ptr = this.head
    var counter = 1
    var msg = "head ---> "
    while(ptr != null){
      if(counter == 1)
        msg = msg + s"${head.data}"
      else
        msg = msg + " ---> " + ptr.data
      counter += 1
      ptr = ptr.next
    }
    msg = msg + " ---> end"
    println(s"LIST OUTPUT: \n$msg\n")
  }

  // Add an element at the beginning
  def push(data: Int) : Unit = {
    if(head == null)
      initialize(data)
    else {
      val newNode = new Node(data)
      newNode.next = head.next
      head.next = newNode
    }

    // Print output
    printList()
  }

  // Add element at the end
  def append(data: Int) : Unit = {
    if(head == null)
      initialize(data)
    else {
      val newNode = new Node(data)
      var pointer = head
      while (pointer.next != null)
        pointer = pointer.next

      pointer.next = newNode
    }

    // Print output
    printList()
  }

  // Add element after a given element
  def insertAfter(data: Int, item: Int) : Unit = {
    var pointer = head
    while(pointer != null && pointer.data != item)
      pointer = pointer.next
    if(pointer == null)
      println(s"ERROR: Item [${item}] not found! Insertion of [${data}] after [${item}] failed!\n")
    else{
      val newNode = new Node(data)
      newNode.next = pointer.next
      pointer.next = newNode
    }

    // Print output
    printList()
  }

  // Add array to LinkedList; appends at the end of the LinkedList
  def appendArray(arr: Array[Int]) : Unit = {
    // Insert elements one by one
    for(elem <- arr){
      // If LinkedList is empty, initialize it with first element of the array
      if(head == null)
        initialize(elem)
      else
        append(elem)
    }

    // Print the output
    printList()
  }

  // Delete a given item from LinkedList
  def delete(item: Int) : Unit = {
    var pointer = head
    var prev = head
    // Find the item to be deleted
    while(pointer != null && pointer.data != item) {
      prev = pointer
      pointer = pointer.next
    }

    // Confirm if item exists and then delete
    if(pointer == null)
      println(s"ERROR: Cannot delete item [${item}]! Item does not exist!")
    else{
      prev.next = pointer.next
    }

    // Print the output
    printList()
  }

  // Delete an item at a given index
  def deleteAtIndex(index: Int) : Unit = {
    var pointer = head
    var prev = head
    var counter = -1
    while(pointer.next != null && counter < index){
      prev = pointer
      pointer = pointer.next
      counter += 1
    }

    if(counter < index)
      println(s"ERROR: Cannot delete. Index [${index}] exceeds the index range for the elements [0 to ${counter}]!\n")
    else{
      println(s"PointerIndex: ${counter}")
      prev.next = pointer.next
    }

    // Print the output
    printList()
  }

  // Returns the length of the LinkedList
  def length: Int = {
    var pointer = head
    var counter = 0
    while(pointer.next != null) {
      pointer = pointer.next
      counter += 1
    }
    counter
  }

  // Reverse the LinkedList
  def reverse() : Unit = {
    var curr : Node = head
    var prev : Node = null
    var temp : Node = null

    while(curr != null){
      temp = curr.next
      curr.next = prev
      prev = curr
      curr = temp
    }
    // Reassign the head
    head = prev

    // Print output
    printList()
  }
}
