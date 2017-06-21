/*
 * Copyright 2017 Tran Le Duy
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.duy.casiofx.factory;

import com.duy.casiofx.token.VectorFunction;
import com.duy.casiofx.util.VectorUtilities;
import com.duy.casiofx.token.NumberToken;
import com.duy.casiofx.token.Token;
import com.duy.casiofx.token.VectorToken;

/**
 * Contains static factory methods for Functions used by Vector Mode.
 *
 * @author Alston Lin
 * @version 3.0
 */
public class VectorFunctionFactory {
    public static VectorFunction makeMagnitude() {
        return new VectorFunction("MAGNITUDE", VectorFunction.MAGNITUDE) {
            @Override
            public NumberToken perform(VectorToken v) {
                return new NumberToken(VectorUtilities.calculateMagnitude(v));
            }
        };
    }

    public static VectorFunction makeUnit() {
        return new VectorFunction("Û", VectorFunction.UNIT) {
            @Override
            public Token perform(VectorToken v) {
                double magnitude = VectorUtilities.calculateMagnitude(v);
                double[] unitVector = new double[v.getDimensions()];
                for (int i = 0; i < v.getDimensions(); i++) {
                    unitVector[i] = v.getValues()[i] / magnitude;
                }
                return new VectorToken(unitVector);
            }

        };
    }
}
