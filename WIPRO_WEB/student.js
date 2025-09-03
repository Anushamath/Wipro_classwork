// ================== TIMER ==================
function updateTimer() {
    const now = new Date();
    document.getElementById("timer").textContent = now.toLocaleTimeString();
}
setInterval(updateTimer, 1000);
updateTimer();

// ================== REPORT CARD ==================
document.getElementById("reportForm").addEventListener("submit", function(event) {
    event.preventDefault();  

    let marksInput = document.getElementById("marksInput").value.trim();

    if (!marksInput) {
        alert("Please enter marks separated by commas.");
        return;
    }

    let marksArray = marksInput.split(",").map(m => parseFloat(m.trim()));

    if (marksArray.some(isNaN)) {
        alert("Please enter only numeric values.");
        return;
    }

    let totalMarks = marksArray.reduce((sum, mark) => sum + mark, 0);
    let percentage = totalMarks / marksArray.length;

    let grade;
    if (percentage >= 90) grade = "A+";
    else if (percentage >= 80) grade = "A";
    else if (percentage >= 70) grade = "B";
    else if (percentage >= 60) grade = "C";
    else if (percentage >= 50) grade = "D";
    else grade = "F";

    let output = `
        <div class="card p-3 shadow">
            <h4>Report Card</h4>
            <ul>
                ${marksArray.map((mark, index) => `<li>Subject ${index + 1}: ${mark}</li>`).join("")}
            </ul>
            <p><strong>Total Marks:</strong> ${totalMarks}</p>
            <p><strong>Percentage:</strong> ${percentage.toFixed(2)}%</p>
            <p><strong>Grade:</strong> ${grade}</p>
        </div>
    `;

    document.getElementById("result").innerHTML = output;

    const reportCard = {
        subjects: marksArray.length,
        marks: marksArray,
        total: totalMarks,
        percentage: percentage.toFixed(2),
        grade: grade
    };
    console.log(JSON.stringify(reportCard, null, 2));
});

// ================== TO-DO LIST WITH CLOSURE ==================
function createTodoList() {
    let tasks = [];

    return {
        addTask: function(task) {
            tasks.push(task);
        },
        removeTask: function(index) {
            tasks.splice(index, 1);
        },
        getTasks: function() {
            return tasks;
        }
    };
}

const todo = createTodoList();

document.getElementById("addTaskBtn").addEventListener("click", () => {
    let task = document.getElementById("taskInput").value.trim();
    if (task) {
        todo.addTask(task);
        document.getElementById("taskInput").value = "";
        displayTasks();
    }
});

function displayTasks() {
    let taskList = document.getElementById("taskList");
    taskList.innerHTML = "";

    todo.getTasks().forEach((task, index) => {
        let li = document.createElement("li");
        li.className = "list-group-item";
        li.textContent = task;

        let removeBtn = document.createElement("button");
        removeBtn.textContent = "X";
        removeBtn.className = "remove-btn";
        removeBtn.onclick = () => {
            todo.removeTask(index);
            displayTasks();
        };

        li.appendChild(removeBtn);
        taskList.appendChild(li);
    });
}

// ================== CALCULATOR USING ARROW FUNCTIONS ==================
const add = (a, b) => a + b;
const subtract = (a, b) => a - b;
const multiply = (a, b) => a * b;

document.getElementById("calcBtn").addEventListener("click", () => {
    let num1 = parseFloat(document.getElementById("num1").value);
    let num2 = parseFloat(document.getElementById("num2").value);
    let operation = document.getElementById("operation").value;

    if (isNaN(num1) || isNaN(num2)) {
        alert("Please enter the both numbers.");
        return;
    }

    let result;
    if (operation === "+") result = add(num1, num2);
    else if (operation === "-") result = subtract(num1, num2);
    else if (operation === "*") result = multiply(num1, num2);

    document.getElementById("calcResult").textContent = `Result: ${result}`;
});
