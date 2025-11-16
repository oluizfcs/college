const correctAnswers = ["q14", "q22", "q32"];

const checkAnswers = document.querySelector("button");

checkAnswers.addEventListener("click", () => {
    const answers = [];
    document.querySelectorAll("input").forEach(e => {
        if (e.checked) {
            answers.push(e.id);
        }
    });

    let score = 0;

    for (let i = 0; i < correctAnswers.length; i++) {
        if (correctAnswers[i] === answers[i]) {
            score++;
        }
    }

    const highscore = localStorage.getItem("highscore");

    if (highscore === null || highscore < score) {
        localStorage.setItem("highscore", score);
    }

    document.getElementById("result").innerText = "Right answers: " + score;
});