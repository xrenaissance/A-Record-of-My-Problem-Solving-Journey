package ProbabilitySamplingRandomization;

/**
 * @author Egbert Li
 * @date
 */
public class ReservoirSampling {
    // This class will be used as reader and it read each of
    // the element by calling the read() method
    // by calling the sample() method, it will return the sample
    // of whatever read before.

    // how many numbers have been read so far.
    private int count;
    // only need to maintain the current sample
    private Integer sample;
    public ReservoirSampling() {
        // initialization, count is initialized as 0 since there is
        // no single number read at the beginning.
        this.count = 0;
        this.sample = null;
    }
    // Analysis
    // proof of the algo:
    // 1. counter = 1, sample = a (init)
    // 2. counter = 2, P(sample = b) = 1/2, p(sample=a) = 1 - p(sample = b) = 1 - 1/2 = 1/2
    // 3. counter = 3, p(sample = c/replace sample with c) = 1/3, p(b survivies after step 3) =
    // p(b srvivies after step 2) * p(b is not replaced after step 3) = 1/2 * (1 - 1/3) = 1/3
    public void read(int value) {
        count++;
        int prob = (int) (Math.random() * count);
        // the current read value has the probability of 1/count to be as the
        // current sample
        if (prob == 0) {
            sample = value;
        }
    }

    public Integer sample() {
        return sample;
    }
}