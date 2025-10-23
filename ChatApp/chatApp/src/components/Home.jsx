import { useRef, useState, useEffect } from 'react';

function Home() {
  const [messages, setMessages] = useState([]);
  const [inputMessage, setInputMessages] = useState("");
  const [userName, setUserName] = useState("");
  const [receiverName, setReceiverName] = useState("");
  const [isConnected, setIsConnected] = useState(false);

  const socket = useRef(null);

  // Send message to server
  const sendMessage = (e) => {
    e.preventDefault();
    if (!inputMessage || !userName || !receiverName) {
      alert("Please enter sender, receiver, and message");
      return;
    }

    const messageObj = {
      senderName: userName,
      receiverName: receiverName,
      message: inputMessage
    };

    socket.current.send(JSON.stringify(messageObj));
    setInputMessages("");
  };

  // Fetch chat history from backend
  const loadChatHistory = () => {
    if (userName && receiverName) {
      fetch(`http://localhost:8080/chat/history?user1=${userName}&user2=${receiverName}`)
        .then(res => res.json())
        .then(data => setMessages(data))
        .catch(err => console.error("Error fetching history:", err));
    } else {
      alert("Enter both sender and receiver names first");
    }
  };

  // WebSocket setup
  useEffect(() => {
    const wsUri = "ws://localhost:8080/ws";
    const websocket = new WebSocket(wsUri);
    socket.current = websocket;

    websocket.onopen = () => {
      console.log("✅ Connected to WebSocket server");
      setIsConnected(true);
    };

    websocket.onmessage = (event) => {
      try {
        const msg = JSON.parse(event.data);
        console.log("💬 Message received:", msg);
        setMessages(prev => [...prev, msg]);
      } catch (e) {
        console.error("Error parsing message:", e);
      }
    };

    websocket.onclose = () => {
      console.log("❌ WebSocket closed");
      setIsConnected(false);
    };

    return () => websocket.close();
  }, []);

  return (
    <>
      <h2>💬 Simple Chat</h2>
      <p>Status: {isConnected ? "🟢 Connected" : "🔴 Disconnected"}</p>

      <div style={{ marginBottom: "10px" }}>
        <input
          type="text"
          placeholder="Your Name"
          onChange={(e) => setUserName(e.target.value)}
          value={userName}
        />
        <br />

        <input
          type="text"
          placeholder="Receiver Name"
          onChange={(e) => setReceiverName(e.target.value)}
          value={receiverName}
        />
        <br />

        <button type="button" onClick={loadChatHistory}>
          Load Chat History
        </button>
      </div>

      <div style={{
        border: "1px solid #ccc",
        padding: "10px",
        height: "250px",
        overflowY: "auto",
        marginBottom: "10px"
      }}>
        {messages.map((m, i) => (
          <p key={i}>
            <b>{m.senderName}</b>: {m.message}
          </p>
        ))}
      </div>

      <form>
        <input
          type="text"
          placeholder="Type a message..."
          onChange={(e) => setInputMessages(e.target.value)}
          value={inputMessage}
        />
        <br />
        <button
          type="button"
          onClick={sendMessage}
          disabled={!isConnected}
        >
          Send
        </button>
      </form>
    </>
  );
}

export default Home;
