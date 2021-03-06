/**
 * Copyright 2016 Nikita Koksharov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.redisson.api;

import java.util.Collection;
import java.util.Map;

import org.redisson.client.protocol.ScoredEntry;

public interface RScoredSortedSetAsync<V> extends RExpirableAsync {

    RFuture<V> pollLastAsync();

    RFuture<V> pollFirstAsync();

    RFuture<V> firstAsync();

    RFuture<V> lastAsync();

    RFuture<Long> addAllAsync(Map<V, Double> objects);

    RFuture<Integer> removeRangeByScoreAsync(double startScore, boolean startScoreInclusive, double endScore, boolean endScoreInclusive);

    RFuture<Integer> removeRangeByRankAsync(int startIndex, int endIndex);

    RFuture<Integer> rankAsync(V o);
    
    RFuture<Integer> revRankAsync(V o);

    RFuture<Double> getScoreAsync(V o);

    /**
     * Adds element to this set, overrides previous score if it has been already added.
     *
     * @param score
     * @param object
     * @return <code>true</code> if element has added and <code>false</code> if not.
     */
    RFuture<Boolean> addAsync(double score, V object);

    /**
     * Adds element to this set only if has not been added before.
     * <p>
     * Works only with <b>Redis 3.0.2 and higher.</b>
     *
     * @param score
     * @param object
     * @return <code>true</code> if element has added and <code>false</code> if not.
     */
    RFuture<Boolean> tryAddAsync(double score, V object);

    RFuture<Boolean> removeAsync(V object);

    RFuture<Integer> sizeAsync();

    RFuture<Boolean> containsAsync(Object o);

    RFuture<Boolean> containsAllAsync(Collection<?> c);

    RFuture<Boolean> removeAllAsync(Collection<?> c);

    RFuture<Boolean> retainAllAsync(Collection<?> c);

    RFuture<Double> addScoreAsync(V object, Number value);

    RFuture<Collection<V>> valueRangeAsync(int startIndex, int endIndex);

    RFuture<Collection<ScoredEntry<V>>> entryRangeAsync(int startIndex, int endIndex);

    RFuture<Collection<V>> valueRangeAsync(double startScore, boolean startScoreInclusive, double endScore, boolean endScoreInclusive);

    RFuture<Collection<V>> valueRangeReversedAsync(double startScore, boolean startScoreInclusive, double endScore, boolean endScoreInclusive);

    RFuture<Collection<ScoredEntry<V>>> entryRangeAsync(double startScore, boolean startScoreInclusive, double endScore, boolean endScoreInclusive);

    RFuture<Collection<V>> valueRangeAsync(double startScore, boolean startScoreInclusive, double endScore, boolean endScoreInclusive, int offset, int count);

    RFuture<Collection<V>> valueRangeReversedAsync(double startScore, boolean startScoreInclusive, double endScore, boolean endScoreInclusive, int offset, int count);

    RFuture<Collection<ScoredEntry<V>>> entryRangeAsync(double startScore, boolean startScoreInclusive, double endScore, boolean endScoreInclusive, int offset, int count);

    RFuture<Collection<ScoredEntry<V>>> entryRangeReversedAsync(double startScore, boolean startScoreInclusive, double endScore, boolean endScoreInclusive, int offset, int count);

    /**
     * Returns the number of elements with a score between <code>startScore</code> and <code>endScore</code>.
     * 
     * @param startScore
     * @param startScoreInclusive
     * @param endScore
     * @param endScoreInclusive
     * @return
     */
    RFuture<Long> countAsync(double startScore, boolean startScoreInclusive, double endScore, boolean endScoreInclusive);
    
    /**
     * Read all values at once.
     * 
     * @return
     */
    RFuture<Collection<V>> readAllAsync();
    
}
