package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.references.CloseableReference;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class NativePooledByteBuffer
  implements PooledByteBuffer
{
  @VisibleForTesting
  @GuardedBy("this")
  CloseableReference<NativeMemoryChunk> mBufRef;
  private final int mSize;
  
  public NativePooledByteBuffer(CloseableReference<NativeMemoryChunk> paramCloseableReference, int paramInt)
  {
    Preconditions.checkNotNull(paramCloseableReference);
    if ((paramInt >= 0) && (paramInt <= ((NativeMemoryChunk)paramCloseableReference.get()).getSize())) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      this.mBufRef = paramCloseableReference.clone();
      this.mSize = paramInt;
      return;
    }
  }
  
  public void close()
  {
    try
    {
      CloseableReference.closeSafely(this.mBufRef);
      this.mBufRef = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  void ensureValid()
  {
    try
    {
      if (isClosed()) {
        throw new PooledByteBuffer.ClosedException();
      }
    }
    finally {}
  }
  
  public long getNativePtr()
  {
    try
    {
      ensureValid();
      long l = ((NativeMemoryChunk)this.mBufRef.get()).getNativePtr();
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public boolean isClosed()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 49	com/facebook/imagepipeline/memory/NativePooledByteBuffer:mBufRef	Lcom/facebook/common/references/CloseableReference;
    //   6: invokestatic 77	com/facebook/common/references/CloseableReference:isValid	(Lcom/facebook/common/references/CloseableReference;)Z
    //   9: istore_1
    //   10: iload_1
    //   11: ifne +9 -> 20
    //   14: iconst_1
    //   15: istore_1
    //   16: aload_0
    //   17: monitorexit
    //   18: iload_1
    //   19: ireturn
    //   20: iconst_0
    //   21: istore_1
    //   22: goto -6 -> 16
    //   25: astore_2
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_2
    //   29: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	30	0	this	NativePooledByteBuffer
    //   9	13	1	bool	boolean
    //   25	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	10	25	finally
  }
  
  /* Error */
  public byte read(int paramInt)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_0
    //   6: invokevirtual 71	com/facebook/imagepipeline/memory/NativePooledByteBuffer:ensureValid	()V
    //   9: iload_1
    //   10: iflt +43 -> 53
    //   13: iconst_1
    //   14: istore_3
    //   15: iload_3
    //   16: invokestatic 43	com/facebook/common/internal/Preconditions:checkArgument	(Z)V
    //   19: iload_1
    //   20: aload_0
    //   21: getfield 51	com/facebook/imagepipeline/memory/NativePooledByteBuffer:mSize	I
    //   24: if_icmpge +34 -> 58
    //   27: iload 4
    //   29: istore_3
    //   30: iload_3
    //   31: invokestatic 43	com/facebook/common/internal/Preconditions:checkArgument	(Z)V
    //   34: aload_0
    //   35: getfield 49	com/facebook/imagepipeline/memory/NativePooledByteBuffer:mBufRef	Lcom/facebook/common/references/CloseableReference;
    //   38: invokevirtual 33	com/facebook/common/references/CloseableReference:get	()Ljava/lang/Object;
    //   41: checkcast 35	com/facebook/imagepipeline/memory/NativeMemoryChunk
    //   44: iload_1
    //   45: invokevirtual 81	com/facebook/imagepipeline/memory/NativeMemoryChunk:read	(I)B
    //   48: istore_2
    //   49: aload_0
    //   50: monitorexit
    //   51: iload_2
    //   52: ireturn
    //   53: iconst_0
    //   54: istore_3
    //   55: goto -40 -> 15
    //   58: iconst_0
    //   59: istore_3
    //   60: goto -30 -> 30
    //   63: astore 5
    //   65: aload_0
    //   66: monitorexit
    //   67: aload 5
    //   69: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	this	NativePooledByteBuffer
    //   0	70	1	paramInt	int
    //   48	4	2	b	byte
    //   14	46	3	bool1	boolean
    //   1	27	4	bool2	boolean
    //   63	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   5	9	63	finally
    //   15	27	63	finally
    //   30	49	63	finally
  }
  
  /* Error */
  public void read(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 71	com/facebook/imagepipeline/memory/NativePooledByteBuffer:ensureValid	()V
    //   6: iload_1
    //   7: iload 4
    //   9: iadd
    //   10: aload_0
    //   11: getfield 51	com/facebook/imagepipeline/memory/NativePooledByteBuffer:mSize	I
    //   14: if_icmpgt +33 -> 47
    //   17: iconst_1
    //   18: istore 5
    //   20: iload 5
    //   22: invokestatic 43	com/facebook/common/internal/Preconditions:checkArgument	(Z)V
    //   25: aload_0
    //   26: getfield 49	com/facebook/imagepipeline/memory/NativePooledByteBuffer:mBufRef	Lcom/facebook/common/references/CloseableReference;
    //   29: invokevirtual 33	com/facebook/common/references/CloseableReference:get	()Ljava/lang/Object;
    //   32: checkcast 35	com/facebook/imagepipeline/memory/NativeMemoryChunk
    //   35: iload_1
    //   36: aload_2
    //   37: iload_3
    //   38: iload 4
    //   40: invokevirtual 85	com/facebook/imagepipeline/memory/NativeMemoryChunk:read	(I[BII)I
    //   43: pop
    //   44: aload_0
    //   45: monitorexit
    //   46: return
    //   47: iconst_0
    //   48: istore 5
    //   50: goto -30 -> 20
    //   53: astore_2
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_2
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	NativePooledByteBuffer
    //   0	58	1	paramInt1	int
    //   0	58	2	paramArrayOfByte	byte[]
    //   0	58	3	paramInt2	int
    //   0	58	4	paramInt3	int
    //   18	31	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	17	53	finally
    //   20	44	53	finally
  }
  
  public int size()
  {
    try
    {
      ensureValid();
      int i = this.mSize;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imagepipeline/memory/NativePooledByteBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */