import { render, screen, within } from '@testing-library/react';
import App from './App';

test('true is true', () => {
    expect(true).toBe(true);
});

describe('App', () => {
    it('renders without crashing', () => {
        render(<App />);
        const app = screen.getByRole('banner');
        expect(app).toBeInTheDocument();
    });

    it('displays logo with "n!"', () => {
        render(<App />);
        const logo = screen.getByRole('heading', {
            name: /n !/i
        })
        expect(logo).toBeInTheDocument();
    });

    it('displays title "Factorial"', () => {
        render(<App />);
        const banner = screen.getByRole('banner');
        const title = within(banner).getByText(/factorial/i);
        expect(title).toBeInTheDocument();
    });
    
    it('displays text input', () => {
        render(<App />);
        const input = screen.getByRole('textbox');
        expect(input).toBeInTheDocument();
    });

    it('displays button', () => {
        render(<App />);
        const button = screen.getByRole('button');
        expect(button).toBeInTheDocument();
    });
});

