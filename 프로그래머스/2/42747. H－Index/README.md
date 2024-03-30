# [level 2] H-Index - 42747 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/42747)   



---

**문제 설명([https://school.programmers.co.kr/learn/courses/30/lessons/42747](https://school.programmers.co.kr/learn/courses/30/lessons/42747))**
​
> H-Index는 과학자의 생산성과 영향력을 나타내는 지표입니다.  
> 어느 과학자의 H-Index를 나타내는 값인 h를 구하려고 합니다. 위키백과1에 따르면, H-Index는 다음과 같이 구합니다.  
>   
> 어떤 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면 h의 최댓값이 이 과학자의 H-Index입니다.  
>   
> 어떤 과학자가 발표한 논문의 인용 횟수를 담은 배열 citations가 매개변수로 주어질 때, 이 과학자의 H-Index를 return 하도록 solution 함수를 작성해주세요.



​
**제한 사항** 
​
> 1\. 과학자가 발표한 논문의 수는 1편 이상 1,000편 이하입니다.  
> 2\. 논문별 인용 횟수는 0회 이상 10,000회 이하입니다.



​
**입출력 예시 & 설명**
​
| citations | return |
| --- | --- |
| \[3, 0, 6, 1, 5\] | 3 |  



​
##### 설명 : 이 과학자가 발표한 논문의 수는 5편이고, 그중 3편의 논문은 3회 이상 인용되었습니다.   그리고 나머지 2편의 논문은 3회 이하 인용되었기 때문에 이 과학자의 H-Index는 3입니다.
​
---
​
**문제 풀이**
​
**👽 (왹져의 생각)**: citations 배열의 길이는 논문의 갯수, 배열 안에 있는 각각 요소 (숫자)는 인용된 횟수를 나타내니.. citations 배열을 오름차순으로 정렬한 다음에... (0 1 3 5 6 뭐 이렇게 순서가 바뀔거구...) ...아 그러고..나서..  
조건을 한번 걸어서 거기서 필터링을 거친 다음에( N회 이하 인용된 논문들 걸러)  ​
조건 : 밖에서 for문을 걸어서, i = 0부터 배열의 길이 -1 까지 조건문 돌리게 한 다음에  ​
그 for문 속 if문을 또 넣어서 조건문에는   
```java
if(arr\[i\] = arr.length - i) {
​
answer = arr\[i\]
​
return answer;
​
}
​```
해보기?  ​
그런데 이렇게 하면 math.Max 메소드 활용해서 남아있는 배열 요소 중..최댓값을 구하지 않아도 될거같기도?    
아 근데 이 위에 조건을 한번 거는 것이 너무 어렵단말이지...이 조건이 맞는지 모르겠음.....ㅋㅋ


​
**내가 풀어본 방식**
​


```java
import java.util.*;
​
class Solution {
    public int solution(int[] citations) {
                int answer = 0;
            Arrays.sort(citations);
        
        for(int i = 0; i<citations.length -1; i++) {
            if(citations[i] == citations.length - i) {
                answer = citations[i];
            }
        }
       
        return answer;
    }
}
```
​
.
​
.
​
.
​
채점 결과는?
​
[##_Image|kage@brjZ1l/btsGeATSlCq/XmRbZeQNjv3B06dd07c4uk/img.png|CDM|1.3|{"originWidth":1088,"originHeight":517,"style":"alignCenter"}_##]
​
....(처참)
​
---
​
**_부끄러운 오답은 잊기로 하고_**
​
**_이제 다시 정답으로 나아가 볼까요?_**
​
---
​
**정답**
​
```
import java.util.*;
​
class Solution {
    public int solution(int[] citations) {
                int answer = 0;
                Arrays.sort(citations); //배열을 오름차수 정렬합니다 - 0 1 3 5 6 (논문 인용 횟수 배열)
                int n = citations.length; //배열의 길이는 즉, 논문의 갯수 : n = 5 
            
        
        for(int i = 0; i<n-1; i++) { //i=0 ~ i=4까지 배열 요소 순회
             int h_index = citations.length - i; //h_index : 현재 순회중인 위치까지 포함하여 이 이후에 있는 논문 갯수
            if(citations[i] >= h_index) { //citations[i] : 특정 논문의 인용 횟수 >= 현재 순회중인 위치까지 포함하여 이 이후에 있는 논문 갯수
                answer = h_index;
                    break;
                
            }
        }
       
        return answer;
    }
    
}
```
​
![image](https://github.com/mithzinf/CoteQueen/assets/124668883/79ec5e78-a6f3-47ba-bf88-6a9b3972f47c)



---



### 성능 요약

메모리: 77.5 MB, 시간: 0.60 ms

### 구분

코딩테스트 연습 > 정렬

### 채점결과

정확성: 100.0<br/>합계: 100.0 / 100.0

### 제출 일자

2024년 03월 30일 18:28:45

### 문제 설명

<p>H-Index는 과학자의 생산성과 영향력을 나타내는 지표입니다. 어느 과학자의 H-Index를 나타내는 값인 h를 구하려고 합니다. 위키백과<sup id="fnref1"><a href="#fn1">1</a></sup>에 따르면, H-Index는 다음과 같이 구합니다.</p>

<p>어떤 과학자가 발표한 논문 <code>n</code>편 중, <code>h</code>번 이상 인용된 논문이 <code>h</code>편 이상이고 나머지 논문이 h번 이하 인용되었다면 <code>h</code>의 최댓값이 이 과학자의 H-Index입니다.</p>

<p>어떤 과학자가 발표한 논문의 인용 횟수를 담은 배열 citations가 매개변수로 주어질 때, 이 과학자의 H-Index를 return 하도록 solution 함수를 작성해주세요.</p>

<h5>제한사항</h5>

<ul>
<li>과학자가 발표한 논문의 수는 1편 이상 1,000편 이하입니다.</li>
<li>논문별 인용 횟수는 0회 이상 10,000회 이하입니다.</li>
</ul>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>citations</th>
<th>return</th>
</tr>
</thead>
        <tbody><tr>
<td>[3, 0, 6, 1, 5]</td>
<td>3</td>
</tr>
</tbody>
      </table>
<h5>입출력 예 설명</h5>

<p>이 과학자가 발표한 논문의 수는 5편이고, 그중 3편의 논문은 3회 이상 인용되었습니다. 그리고 나머지 2편의 논문은 3회 이하 인용되었기 때문에 이 과학자의 H-Index는 3입니다.</p>

<h5>문제가 잘 안풀린다면😢</h5>

<p>힌트가 필요한가요? [코딩테스트 연습 힌트 모음집]으로 오세요! → <a href="https://school.programmers.co.kr/learn/courses/14743?itm_content=lesson42747" target="_blank" rel="noopener">클릭</a></p>

<p>※ 공지 - 2019년 2월 28일 테스트 케이스가 추가되었습니다.</p>

<div class="footnotes">
<hr>
<ol>

<li id="fn1">
<p><a href="https://en.wikipedia.org/wiki/H-index" target="_blank" rel="noopener">https://en.wikipedia.org/wiki/H-index</a> "위키백과"&nbsp;<a href="#fnref1">↩</a></p>
</li>

</ol>
</div>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
