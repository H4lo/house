package com.facebook.imagepipeline.producers;

public class NullProducer<T>
  implements Producer<T>
{
  public void produceResults(Consumer<T> paramConsumer, ProducerContext paramProducerContext)
  {
    paramConsumer.onNewResult(null, true);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imagepipeline/producers/NullProducer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */