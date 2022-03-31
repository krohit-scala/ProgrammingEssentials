package dataStructures.impl.queues

class QueueArray {
  var arr : Array[Int] = Array.fill(1){-1}
  var capacity : Int = 1
  var rear : Int = -1
  var length : Int = 0

  // front not needed, as deletion would happen at the index 0 only

  // Resize the Queue
  def resize : Unit = {
    this.capacity *= 2
    val newArr = Array.fill(this.capacity){-1}
    for(i <- 0.until(arr.length))
      newArr(i) = arr(i)
    this.arr = newArr
  }

  // Check if Queue is empty
  def isEmpty : Boolean = {
    this.rear == -1
  }

  // Check if Queue is not empty
  def isNotEmpty : Boolean = {
    !this.isEmpty
  }

  // Check if Queue is full
  def isFull : Boolean = {
    this.length == this.capacity
  }

  // Check if Queue is not full
  def isNotFull : Boolean = {
    !this.isFull
  }

  // Enqueue in the Queue
  def enqueue(item: Int) : Unit = {
    // Check if the Queue is full
    if(this.isFull)
      resize

    this.rear += 1
    this.arr(this.rear) = item
    this.length += 1
  }

  // Enqueue Array elements into Queue
  def enqueueArray(arr: Array[Int]): Unit = {
    for(elem <- arr)
      enqueue(elem)
  }

  // Dequeue elements
  def dequeue : Int = {
    // Dequeue happens at the 0-th index
    val elem = this.arr(0)
    for(i <- 0.until(this.length))
      arr(i) = arr(i+1)
    this.rear -= 1
    this.length -=1
    elem
  }

  // Get the length of the Queue
  def getSize : Int = {
    this.length
  }

  // Print the queue:
  def printQueue : String = {
    if(this.isEmpty)
      return "Error: Queue is empty!"

    // If Queue is not empty, get the elements from the Queue
    val data = for(i <- 0.until(this.length)) yield this.arr(i)
    "front --> " + data.mkString(" -- ") + " <-- rear"
  }
}