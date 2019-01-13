class Solution:
    def numUniqueEmails(self, emails):
        """
        :type emails: List[str]
        :rtype: int
        """
        # . : combine
        # + : after the 1st one will be ignored

        # Edge case:
        #   - Just @ symbol
        #   - . or + after @ symbol

        for idx, each_email in enumerate(emails):
            # Take out string after @ symbol (split)
            prefix, suffix = each_email.split("@")

            # Filter out dot symbol by replacing it
            clean_prefix = prefix.replace(".", "")

            idx_plus = clean_prefix.index("+")
            if idx_plus >= 0:
                clean_prefix = clean_prefix[:idx_plus]

            # Merge back
            emails[idx] = clean_prefix + "@" + suffix

        return len(set(emails))
