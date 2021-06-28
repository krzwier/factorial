import './App.css';



const getFactorial = async (e) => {
    const num = document.querySelector("input").value;
    if (num === "") {
        return;
    }
    const url = `https://factorial-factory.herokuapp.com/api/factorial?input=${num}`;
    const message = document.querySelector("#answer");
    let res;
    res = await fetch(url);
    const ans = await res.text();
    if (res.status === 200) {
        message.textContent = `${num}! = ${ans}`;
        message.style.fontSize = "2em";
    } else {
        message.textContent = ans;
        message.style.fontSize = "1em";
    }

}

const checkKey = async (e) => {
    if (e.key === 'Enter') {
        await getFactorial();
    }
}


function App() {

    return (
        <div className="App">
            <div className="App-wrapper">
                <header className="App-header">
                    <div className="App-logo">
                        <h1>n !</h1>
                    </div>
                    <p>
                        Factorial
                    </p>
                </header>
                <div className="App-body">
                    <input type="text" onKeyDown={checkKey} className="number" placeholder="Enter a number" />
                    <button onClick={getFactorial}>Get Factorial</button>
                    <p id="answer" data-testid="answer">&nbsp;</p>
                </div>
                <div className="notice">
                    <p>Please note: the back-end REST service for this app is hosted on a free server that sleeps between uses. It may take ~10 seconds for first response, but subsequent responses will be immediate.</p>
                </div>
            </div>
        </div>
    );

}


export default App;
