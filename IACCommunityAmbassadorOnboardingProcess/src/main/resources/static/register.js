document.addEventListener("DOMContentLoaded", () => {
  const form = document.getElementById("caForm");
  const nameInput = document.getElementById("name");
  const emailInput = document.getElementById("email");
  const phoneInput = document.getElementById("phone");
  const addressInput = document.getElementById("address");
  const collegeInput = document.getElementById("college");
  const resultMsg = document.getElementById("resultMsg");

  form.addEventListener("submit", async (e) => {
    e.preventDefault();

    const name = nameInput.value.trim();
    const email = emailInput.value.trim();
    const phone = phoneInput.value.trim();
    const address = addressInput.value.trim();
    const college = collegeInput.value.trim();

    if (!name || !email || !phone || !address || !college) {
      showMessage("⚠️ Please fill in all fields!", "red");
      return;
    }

    try {
      showMessage("⏳ Registering...", "blue");

      const response = await fetch("http://localhost:8080/api/cas/register", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          name,
          email,
          phone,
          address,
          collegeOrUniversity: college  // Correct property name
        }),
      });

      if (response.ok) {
        const data = await response.json();
        showMessage(
          `✅ Registered! Your UTM link: <a href="${data.utmLink}" target="_blank">${data.utmLink}</a>`,
          "green"
        );
        form.reset();  // Reset the form after successful registration
      } else {
        const errorText = await response.text();
        showMessage(`❌ Failed to register: ${errorText}`, "red");
      }
    } catch (error) {
      console.error("Registration failed", error);
      showMessage("❌ Server error. Please try again later.", "red");
    }
  });

  function showMessage(message, color) {
    resultMsg.innerHTML = message;
    resultMsg.style.color = color;
    resultMsg.style.marginTop = "15px";
  }
});
