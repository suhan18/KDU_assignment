let defaultMinutes = 25;
let timeLeft = defaultMinutes * 60;
let timerInterval = null;
let sessionsCompleted = 0;

const timerDisplay = document.getElementById("timer");
const startBtn = document.getElementById("startBtn");
const pauseBtn = document.getElementById("pauseBtn");
const resetBtn = document.getElementById("resetBtn");
const minutesInput = document.getElementById("minutesInput");
const setBtn = document.getElementById("setBtn");
const sessionsDisplay = document.getElementById("sessions");

function updateDisplay() {
  const minutes = Math.floor(timeLeft / 60);
  const seconds = timeLeft % 60;

  timerDisplay.textContent =
    String(minutes).padStart(2, "0") +
    ":" +
    String(seconds).padStart(2, "0");
}

function startTimer() {
  if (timerInterval !== null) return; 
  timerInterval = setInterval(() => {
    timeLeft--;
    updateDisplay();
    if (timeLeft === 0) {
      clearInterval(timerInterval);
      timerInterval = null;
      alert("Session Complete!");
      sessionsCompleted++;
      sessionsDisplay.textContent = sessionsCompleted;
      timeLeft = defaultMinutes * 60;
      updateDisplay();
    }
  }, 1000);
}

function pauseTimer() {
  clearInterval(timerInterval);
  timerInterval = null;
}

function resetTimer() {
  pauseTimer();
  timeLeft = defaultMinutes * 60;
  updateDisplay();
}

function setCustomTimer() {
  const minutes = Number(minutesInput.value);
  if (minutes < 1 || minutes > 60 || isNaN(minutes)) {
    alert("Please enter a number between 1 and 60");
    return;
  }
  defaultMinutes = minutes;
  timeLeft = minutes * 60;
  updateDisplay();
  pauseTimer();
}

startBtn.addEventListener("click", startTimer);
pauseBtn.addEventListener("click", pauseTimer);
resetBtn.addEventListener("click", resetTimer);
setBtn.addEventListener("click", setCustomTimer);

updateDisplay();
