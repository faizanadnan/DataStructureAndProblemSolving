package random;

import java.util.Arrays;
import java.util.List;

public class GoogleProblemOne {


    public static final int mod = 1000000007; // for int, or 1000000000000000007L for long

    /*

    Two closely-related codebases you maintain are being merged together into a single project. As part of that merge, you want to combine the
     CHANGELOG.txt from each project into a single CHANGELOG.txt
     which retains the release notes from both projects.

Each release in a changelog looks like:

    1.12.8
    ---------
    * Add a shiny new feature
    * Fix bug #1234567

or like:

    1.0.138
    ---------
    * Add an often-requested feature


The version number of each release is a semantic version number (semver). Releases in the merged changelog should be sorted by descending version number, so the latest release is at the top. Because of historical accident, you cannot assume the *input* changelogs are sorted correctly.

If both changelogs have a release with the same version number, the entries for that release should be merged into a single release entry. The bulleted list of release notes from the second project’s changelog should be appended to the bulleted list of notes from the first project for that release.


Full example inputs/output:

input_1 =
"""
2021.2.23
---------
* Break backwards-compatibility

2020.12.28
----------
* Add a shiny new feature
* Fix bug #23456 (again)

2020.7.20
---------
* Improved performance

2020.4.3
--------
* Fix bug #87654

2020.1.12
---------
* Change versioning scheme
* Fix bug #23456

1.0.0
-----
* Initial release
"""


input_2 =
"""
2020.12.28
---------
* Add an often-requested feature

2020.8.14
---------
* Fix bug #5678
* Fix bug #9001

2020.1.12
---------
* Change versioning scheme

1.0.0
-----
* Initial release

1.0.1
-----
* Emergency patch
"""


result =
"""
2021.2.23
----------
* Break backwards-compatibility

2020.12.28
----------
* Add a shiny new feature
* Fix bug #23456 (again)
* Add an often-requested feature

2020.8.14
----------
* Fix bug #5678
* Fix bug #9001

2020.7.20
----------
* Improved performance

2020.4.3
--------
* Fix bug #87654

2020.1.12
----------
* Change versioning scheme
* Fix bug #23456
* Change versioning scheme

1.0.1
----------
* Emergency patch

1.0.0
----------
* Initial release
* Initial release
"""




     */
    // arr[i] * (i + 1) * (n - i)
    public static int findSum(List<Integer> array, int localLength, int startIndex) {
        int sum = 0;
        for (int i = 0; i < localLength; i++) {
            sum += array.get(startIndex + i) * (i + 1) * (localLength - i);
        }
        return sum % mod;
    }

    public static long subArraySum(List<Integer> arr) {
        int n = arr.size();
        int startindex = 0;
        long totalSum = 0;

        while (startindex < n) {
            int j = startindex + 1;
            int diff = j < n ? arr.get(j) - arr.get(startindex) : 0;

            if ((diff == -1 || diff == 1)) {
                int k = startindex;
                long localSum = 0;
                int localLength = 1;
                while (j < n && arr.get(j) - arr.get(k) == diff) {
                    localLength++;
                    j++;
                    k++;
                }
                localSum = findSum(arr, localLength, startindex);
                totalSum += localSum;
                startindex = k;
                totalSum -= arr.get(k);
            } else {
                totalSum += arr.get(startindex);
                startindex++;
            }
        }
        return totalSum;
    }

    public static void main(String[] args) {
        System.out.println(subArraySum(Arrays.asList(7, 4, 5, 6, 5)));
    }

}
