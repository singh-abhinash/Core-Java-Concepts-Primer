package threadPool;

public class ContextSwitchingExplanation {

}
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/**
 * -> Context switching is the process where a computer’s CPU stops working on
 * one task and starts working on another. When the CPU switches tasks, it saves
 * the state (context) of the current task (like its registers, program counter,
 * etc.) so it can resume it later, then loads the state of the new task to
 * continue where it left off.
 * 
 * -> Think of it like a bookmark system: if you’re reading multiple books, you
 * mark your place in one book before starting another, so you can easily pick
 * up where you left off in each. Similarly, the CPU "remembers" each task's
 * state so it can switch between them efficiently, allowing multiple tasks or
 * threads to appear as if they’re running at the same time.
 * 
 * -> This context switching is essential for multitasking but has a small
 * performance cost since saving and loading states takes time and resources.
 * 
 * -> With the help of thread pool we minimize the context switching.
 */
