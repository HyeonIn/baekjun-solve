function solution(cards1, cards2, goal) {
  var answer = "Yes";
  let left = 0;
  let right = 0;
  for (i = 0; i < goal.length; i++) {
    if (goal[i] == cards1[left]) {
      left++;
    } else if (goal[i] == cards2[right]) {
      right++;
    } else {
      answer = "No";
      break;
    }
  }
  return answer;
}
