
import axiosInstance from "../api/axiosInstance";
import Poll from "../entity/Poll";

export const fetchPolls = async (): Promise<Poll[]> => {
  try {
    const response = await axiosInstance.get<Poll[]>(`/Polls`);
    return response.data;
  } catch (error) {
    console.error("Error fetching Polls:", error);
    throw error;
  }
};

export const fetchOnePoll = async (PollId : number): Promise<Poll> => {
    try {
      const response = await axiosInstance.get<Poll>(`/Polls/${PollId}`);
      return response.data;
    } catch (error) {
      console.error("Error fetching Poll:", error);
      throw error;
    }
  };

export const createPoll = async (Poll: Poll): Promise<Poll> => {
  const response = await axiosInstance.post<Poll>(`/Polls`, Poll);
  return response.data;
};

export const updatePoll = async (PollId: number, Poll: Poll): Promise<Poll> => {
  const response = await axiosInstance.put<Poll>(`/Polls/${PollId}`, Poll);
  return response.data;
};

export const deletePoll = async (PollID: number): Promise<void> => {
  await axiosInstance.delete(`/Polls/${PollID}`);
};
