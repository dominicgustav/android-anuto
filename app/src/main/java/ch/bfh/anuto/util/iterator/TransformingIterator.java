package ch.bfh.anuto.util.iterator;

import java.util.Iterator;

public class TransformingIterator<F, T> extends StreamIterator<T> {

    Function<? super F, ? extends T> mTransformation;
    StreamIterator<F> mOriginal;

    public TransformingIterator(StreamIterator<F> original, Function<? super F, ? extends T> transformation) {
        mOriginal = original;
        mTransformation = transformation;
    }

    @Override
    public void close() {
        mOriginal.close();
    }

    @Override
    public boolean hasNext() {
        return mOriginal.hasNext();
    }

    @Override
    public T next() {
        return mTransformation.apply(mOriginal.next());
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
