import sys
import os

# Ensure the root directory is in sys.path
sys.path.append(os.path.dirname(os.path.abspath(__file__)))

from webapp import app  # Import the app from the webapp module

if __name__ == '__main__':
    app.run(debug=True)
