/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./src/**/*.{html,ts}"],
  theme: {
    extend: {
      colors: {
        customGreen: "#3CBA9D", // Agrega tu color con un nombre personalizado
        customGreenDark: "#46AF95", // Agrega tu color con un nombre personalizado
        activebutton: "#2C2C2C",
      },
    },
  },
  plugins: [],
};
