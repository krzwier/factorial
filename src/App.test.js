import { render, screen, within, fireEvent } from '@testing-library/react';
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

describe('Clicking button', () => {

    it('returns message with answer 120 when input is 5', async () => {

        render(<App />);
        const input = screen.getByRole('textbox');
        input.value = "5";
        const button = screen.getByRole('button');
        fireEvent.click(button);
        const message = await screen.findByText(/(5).*(120)/);
        expect(message).toBeInTheDocument();

    });

    it('returns message with answer 1 when input is 1', async () => {

        render(<App />);
        const input = screen.getByRole('textbox');
        input.value = "1";
        const button = screen.getByRole('button');
        fireEvent.click(button);
        const message = await screen.findByText(/(1).*(1)/);
        expect(message).toBeInTheDocument();

    });

    it('returns message with answer 40320 when input is 8', async () => {

        render(<App />);
        const input = screen.getByRole('textbox');
        input.value = "8";
        const button = screen.getByRole('button');
        fireEvent.click(button);
        const message = await screen.findByText(/(8).*(40320)/);
        expect(message).toBeInTheDocument();
    });

    it('returns message with answer 1 when input is 0', async () => {

        render(<App />);
        const input = screen.getByRole('textbox');
        input.value = "0";
        const button = screen.getByRole('button');
        fireEvent.click(button);
        const message = await screen.findByText(/(0).*(1)/);
        expect(message).toBeInTheDocument();

    });

    it('returns message with correct answer when input is 100', async () => {

        render(<App />);
        const input = screen.getByRole('textbox');
        input.value = "100";
        const button = screen.getByRole('button');
        fireEvent.click(button);
        const message = await screen.findByText(/(100).*(93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000)/);
        expect(message).toBeInTheDocument();

    });

    it('returns error message when input is -1', async () => {

        render(<App />);
        const input = screen.getByRole('textbox');
        input.value = "-1";
        const button = screen.getByRole('button');
        fireEvent.click(button);
        const message = await screen.findByText(/[^\=].*(non-negative).*/i);
        expect(message).toBeInTheDocument();

    });

    it('returns error message when input is 101', async () => {

        render(<App />);
        const input = screen.getByRole('textbox');
        input.value = "101";
        const button = screen.getByRole('button');
        fireEvent.click(button);
        const message = await screen.findByText(/[^\=].*(non-negative).*/i);
        expect(message).toBeInTheDocument();

    });

    it('returns blank message when input is empty', async () => {
        render(<App />);
        const input = screen.getByRole('textbox');
        input.value = "";
        const button = screen.getByRole('button');
        fireEvent.click(button);
        const message = await screen.findByTestId("answer");
        const expected = expect.stringMatching(/^\s$/);
        expect(message.textContent).toEqual(expected);
    })

    it('returns error message when input is not an integer', async () => {

        render(<App />);
        const input = screen.getByRole('textbox');
        input.value = "3.03";
        const button = screen.getByRole('button');
        fireEvent.click(button);
        const message = await screen.findByText(/[^\=].*(integer).*/i);
        expect(message).toBeInTheDocument();

    });

    it('returns error message when input is not a number', async () => {

        render(<App />);
        const input = screen.getByRole('textbox');
        input.value = "hello";
        const button = screen.getByRole('button');
        fireEvent.click(button);
        const message = await screen.findByText(/[^\=].*(number).*/i);
        expect(message).toBeInTheDocument();

    });



});


describe('Hitting enter', () => {

    it('returns message with answer 120 when input is 5', async () => {

        render(<App />);
        const input = screen.getByRole('textbox');
        input.value = "5";
        fireEvent.keyDown(input, { key: 'Enter', code: 'Enter' });
        const message = await screen.findByText(/(5).*(120)/);
        expect(message).toBeInTheDocument();

    });

    it('returns message with answer 1 when input is 1', async () => {

        render(<App />);
        const input = screen.getByRole('textbox');
        input.value = "1";
        fireEvent.keyDown(input, { key: 'Enter', code: 'Enter' });
        const message = await screen.findByText(/(1).*(1)/);
        expect(message).toBeInTheDocument();

    });

    it('returns message with answer 40320 when input is 8', async () => {

        render(<App />);
        const input = screen.getByRole('textbox');
        input.value = "8";
        fireEvent.keyDown(input, { key: 'Enter', code: 'Enter' });
        const message = await screen.findByText(/(8).*(40320)/);
        expect(message).toBeInTheDocument();
    });

    it('returns message with answer 1 when input is 0', async () => {

        render(<App />);
        const input = screen.getByRole('textbox');
        input.value = "0";
        fireEvent.keyDown(input, { key: 'Enter', code: 'Enter' });
        const message = await screen.findByText(/(0).*(1)/);
        expect(message).toBeInTheDocument();

    });

    it('returns message with correct answer when input is 100', async () => {

        render(<App />);
        const input = screen.getByRole('textbox');
        input.value = "100";
        fireEvent.keyDown(input, { key: 'Enter', code: 'Enter' });
        const message = await screen.findByText(/(100).*(93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000)/);
        expect(message).toBeInTheDocument();

    });

    it('returns error message when input is -1', async () => {

        render(<App />);
        const input = screen.getByRole('textbox');
        input.value = "-1";
        fireEvent.keyDown(input, { key: 'Enter', code: 'Enter' });
        const message = await screen.findByText(/[^\=].*(non-negative).*/i);
        expect(message).toBeInTheDocument();

    });

    it('returns error message when input is 101', async () => {

        render(<App />);
        const input = screen.getByRole('textbox');
        input.value = "101";
        fireEvent.keyDown(input, { key: 'Enter', code: 'Enter' });
        const message = await screen.findByText(/[^\=].*(non-negative).*/i);
        expect(message).toBeInTheDocument();

    });

    it('returns blank message when input is empty', async () => {
        render(<App />);
        const input = screen.getByRole('textbox');
        input.value = "";
        fireEvent.keyDown(input, { key: 'Enter', code: 'Enter' });
        const message = await screen.findByTestId("answer");
        const expected = expect.stringMatching(/^\s$/);
        expect(message.textContent).toEqual(expected);
    })

    it('returns error message when input is not an integer', async () => {

        render(<App />);
        const input = screen.getByRole('textbox');
        input.value = "3.03";
        fireEvent.keyDown(input, { key: 'Enter', code: 'Enter' });
        const message = await screen.findByText(/[^\=].*(integer).*/i);
        expect(message).toBeInTheDocument();

    });

    it('returns error message when input is not a number', async () => {

        render(<App />);
        const input = screen.getByRole('textbox');
        input.value = "hello";
        fireEvent.keyDown(input, { key: 'Enter', code: 'Enter' });
        const message = await screen.findByText(/[^\=].*(number).*/i);
        expect(message).toBeInTheDocument();

    });



});
